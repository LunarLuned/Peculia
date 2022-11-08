package net.lunarluned.peculia.mixin.armor;

import io.netty.buffer.Unpooled;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.particles.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class MoldleapBootMixin {

    private int jumpCount = 0;
    private boolean jumpedLastTick = false;

    // Allows for the player to double-jump while wearing Moldleap Boots

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo info) {

        LocalPlayer player = (LocalPlayer) (Object) this;
        ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);

        if (itemStack.is(ModItems.MOLDLEAP_BOOTS)) {

            if (Peculia.getConfig().visualEffects.visualEffectsConfig.particlesConfig.moldleap_boots_ichor_particles) {
                if ((player.tickCount % 5 == 0) && (player.getDeltaMovement().horizontalDistance() > 0) && !player.isInWater()) {
                    float k = (0.3F * 0.45F) * (0.2F + 1.0F);
                    player.level.addParticle(ModParticles.ICHOR, player.getX(), player.getY() + (double) k, player.getZ(), 0.0, 0.0, 0.0);
                }
            }

            if (player.isOnGround() || player.isHandsBusy()) {

                jumpCount = 3;

            } else if (!jumpedLastTick && jumpCount > 0) {

                if (player.input.jumping && !player.getAbilities().flying) {
                    if (canJump(player)) {
                        --jumpCount;
                        player.jumpFromGround();
                        player.playNotifySound(ModSoundEvents.ARMOR_MOLDLEAP_FLAP, SoundSource.PLAYERS, 1.0f, 1.0f);
                        JumpingParticle(player.level, player);
                        FriendlyByteBuf passedData = new FriendlyByteBuf(Unpooled.buffer());
                        passedData.writeUUID(player.getUUID());
                    }
                }
            }
            jumpedLastTick = player.input.jumping;
        }
    }

    @Unique
    private boolean canJump(LocalPlayer player) {
        return !player.isFallFlying() && !player.isRidingJumpable() && !player.isInWater() && !player.hasEffect(MobEffects.LEVITATION) && !player.hasEffect(ModEffects.STUNNED);
    }

    @Unique
    private static void JumpingParticle(Level level, Entity entity) {
        if (Peculia.getConfig().visualEffects.visualEffectsConfig.particlesConfig.ichor_leap_particles) {
            level.addParticle(ModParticles.ICHOR_LEAP, entity.getX(), entity.getY() - 0.45, entity.getZ(), 0.0, 0.0, 0.0);
        }
    }
}
