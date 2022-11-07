package net.lunarluned.peculia.mixin.armor;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo info) {
        LocalPlayer player = (LocalPlayer) (Object) this;
        ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);
        if (player.isOnGround() || player.isHandsBusy()) {
            if (itemStack.is(ModItems.MYTHRIL_BOOTS)) {
                jumpCount = 3;
            }
        } else if (!jumpedLastTick && jumpCount > 0 && itemStack.is(ModItems.MYTHRIL_BOOTS)) {
            if (player.input.jumping && !player.getAbilities().flying) {
                if (canJump(player)) {
                    --jumpCount;
                    player.jumpFromGround();

                    player.level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ARMOR_MOLDLEAP_FLAP, SoundSource.NEUTRAL, 1, 1);
                    JumpingParticle(player.level, player);



                    FriendlyByteBuf passedData = new FriendlyByteBuf(Unpooled.buffer());
                    passedData.writeUUID(player.getUUID());

                }
            }
        }
        jumpedLastTick = player.input.jumping;
    }

    private boolean wearingUsableElytra(LocalPlayer player) {
        ItemStack chestItemStack = player.getItemBySlot(EquipmentSlot.CHEST);;
        return chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isFlyEnabled(chestItemStack);
    }

    private boolean canJump(LocalPlayer player) {
        return !wearingUsableElytra(player) && !player.isFallFlying() && !player.isRidingJumpable()
                && !player.isInWater() && !player.hasEffect(MobEffects.LEVITATION);
    }
    @Unique
    private static void JumpingParticle(Level level, Entity entity) {
        if (Peculia.getConfig().visualEffects.visualEffectsConfig.particlesConfig.ichor_leap_particles) {
            level.addParticle(ModParticles.ICHOR_LEAP, entity.getX(), entity.getY() - 0.45, entity.getZ(), 0.0, 0.0, 0.0);
        }
    }
}
