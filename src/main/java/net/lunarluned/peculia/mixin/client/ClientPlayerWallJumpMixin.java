package net.lunarluned.peculia.mixin.client;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.HashSet;
import java.util.Set;

@Mixin(LocalPlayer.class)
public abstract class ClientPlayerWallJumpMixin extends AbstractClientPlayer {

    @Shadow public abstract boolean isHandsBusy();
    @Shadow public Input input;
    @Shadow public abstract void playSound(@NotNull SoundEvent soundEvent, float f, float g);

    public int ticksWallClinged;
    private int ticksKeyDown;
    private double clingX;
    private double clingZ;
    private double lastJumpY = Double.MAX_VALUE;
    private Set<Direction> walls = new HashSet<>();
    private Set<Direction> staleWalls = new HashSet<>();

    private boolean doesNotCollide(AABB AABB) {
        return this.level.noCollision(this, AABB) && !this.level.containsAnyLiquid(AABB);
    }

    public ClientPlayerWallJumpMixin(ClientLevel clientLevel, GameProfile gameProfile, @Nullable ProfilePublicKey profilePublicKey) {
        super(clientLevel, gameProfile, profilePublicKey);
    }

    @Inject(method = "move", at = @At("TAIL"))
    private void wallJumpTickMovement(CallbackInfo ci) {
        this.doWallJump();
    }

    private void doWallJump() {

        if(!this.canWallJump()) return;

        if(this.onGround || this.getAbilities().flying || !this.level.getFluidState(this.getOnPos()).isEmpty() || this.isHandsBusy() || this.onClimbable()) {
            this.ticksWallClinged = 0;
            this.clingX = Double.NaN;
            this.clingZ = Double.NaN;
            this.lastJumpY = Double.MAX_VALUE;
            this.staleWalls.clear();
            return;
        }
        this.updateWalls();
        this.ticksKeyDown = input.shiftKeyDown ? this.ticksKeyDown + 1 : 0;

        if(this.ticksWallClinged < 1) {
            if (this.ticksKeyDown > 0 && this.ticksKeyDown < 4 && !this.walls.isEmpty() && this.canWallCling()) {
                this.animationSpeed = 2.5F;
                this.animationSpeedOld = 2.5F;
                this.ticksWallClinged = 1; // Wall Slide Delay
                this.clingX = this.getX();
                this.clingZ = this.getZ();
            }
            return;
        }

        // Grabbing Sound

        if (this.ticksWallClinged == 1) {
            this.playSound(ModSoundEvents.MOLDVAULT_CLAW_GRAB, 0.5f, 0.8f + level.random.nextFloat() * 0.4F);
        }

        if(!input.shiftKeyDown || this.onGround || !this.level.getFluidState(this.getOnPos()).isEmpty() || this.walls.isEmpty() || this.getFoodData().getFoodLevel() < 1) {
            this.ticksWallClinged = 0;
            if((this.zza != 0 || this.xxa != 0) && !this.onGround && !this.walls.isEmpty()) {
                this.fallDistance = 0.0F;
                FriendlyByteBuf passedData = new FriendlyByteBuf(Unpooled.buffer());
                passedData.writeBoolean(true);
                ClientPlayNetworking.send(Peculia.WALL_JUMP_PACKET_ID, passedData);
                this.wallJump();
                this.staleWalls = new HashSet<>(this.walls);
            }
            return;
        }

        this.setPos(this.clingX, this.getY(), this.clingZ);
        double motionY = this.getDeltaMovement().y();

        if(motionY > 0.0) {
            motionY = 0.0;
        } else if(motionY < -0.6) {
            motionY = motionY + 0.2;
        } else if(this.ticksWallClinged++ > 100) {
            motionY = -0.1;
        } else {
            motionY = 0.0;
        }

        if(this.fallDistance > 2) {
            this.fallDistance = 0;
            FriendlyByteBuf passedData = new FriendlyByteBuf(Unpooled.buffer());
            passedData.writeFloat((float) (motionY * motionY * 8));
            ClientPlayNetworking.send(Peculia.FALL_DISTANCE_PACKET_ID, passedData);
        }
        this.setDeltaMovement(0.0, motionY, 0.0);
    }

    private boolean canWallJump() {
        ItemStack stack = this.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHand = this.getItemInHand(InteractionHand.OFF_HAND);
        if(stack.is(ModItems.MOLDVAULT_CLAW)) return true;
        if (this.onClimbable()) return false;
        return offHand.is(ModItems.MOLDVAULT_CLAW);
    }

    private boolean canWallCling() {
        if(this.onClimbable() || this.getDeltaMovement().y() > 0.1 || this.getFoodData().getFoodLevel() < 1) return false;
        ItemStack stack = this.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack offHand = this.getItemInHand(InteractionHand.OFF_HAND);
        if(stack.is(ModItems.MOLDVAULT_CLAW) && offHand.is(ModItems.MOLDVAULT_CLAW) || this.getY() < this.lastJumpY - 1) return true;
        return !this.staleWalls.containsAll(this.walls);
    }

    private void updateWalls() {
        AABB aabb = new AABB(
                this.getX() - 0.001,
                this.getY(),
                this.getZ() - 0.001,
                this.getX() + 0.001,
                this.getY() + 1.51,
                this.getZ() + 0.001
        );

        double dist = (this.getBbWidth() / 2) + (this.ticksWallClinged > 0 ? 0.1 : 0.06);

        AABB[] axes = {
                aabb.expandTowards(0, 0, dist),
                aabb.expandTowards(-dist, 0, 0),
                aabb.expandTowards(0, 0, -dist),
                aabb.expandTowards(dist, 0, 0)
        };

        int i = 0;
        Direction direction;
        this.walls = new HashSet<>();

        for (AABB axis : axes) {
            direction = Direction.fromYRot(i++);

            if(!this.doesNotCollide(axis)) {
                this.walls.add(direction);
                this.horizontalCollision = true;
            }
        }
    }

    private void wallJump() {

        float strafe = Math.signum(this.xxa) * (float) 1.0 * (float) 1.0;
        float forward = Math.signum(this.zza) * (float) 1.0 * (float) 1.0;

        float f = 1.0F / Mth.sqrt(strafe * strafe + 1.0f + forward * forward);
        strafe = strafe * f;
        forward = forward * f;

        float f1 = Mth.sin(this.getYHeadRot() * 0.017453292F) * 0.45F;
        float f2 = Mth.cos(this.getYHeadRot() * 0.017453292F) * 0.45F;

        int jumpBoostLevel = 0;
        MobEffectInstance jumpBoostEffect = this.getEffect(MobEffects.JUMP);
        if(jumpBoostEffect != null) jumpBoostLevel = jumpBoostEffect.getAmplifier() + 1;

        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(motion.x() + (strafe * f2 - forward * f1), (float) 1.0 + (jumpBoostLevel * 0.125), motion.z() + (forward * f2 + strafe * f1));
        this.playSound(ModSoundEvents.MOLDVAULT_CLAW_VAULT, 0.8f, 1.0f);
        this.lastJumpY = this.getY();
    }
}
