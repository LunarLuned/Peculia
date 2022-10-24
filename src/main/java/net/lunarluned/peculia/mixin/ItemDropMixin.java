package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.misc.PeculiaTags;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemDropMixin extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    @Shadow
    public abstract void setUnlimitedLifetime();

    protected ItemDropMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // Detects if an item is in the tag to increase pickup range & make it glow
        if (getItem().is(PeculiaTags.ALERTING_ITEMS)) {
            setGlowingTag(true);
            ignoreExplosion();
            setUnlimitedLifetime();
            isInvulnerableTo(DamageSource.OUT_OF_WORLD);
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.96D, -1D, 0.96D));
        }
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void damageItem(CallbackInfo info) {
        if (getItem().is(PeculiaTags.ALERTING_ITEMS) && (this.getY() < this.level.getMinBuildHeight())) {
            level.playSound(null, this.getOnPos(), ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundSource.NEUTRAL, 1.0f, 1.0f);
            this.teleportTo(this.getX(), this.level.getMinBuildHeight() + 45, this.getZ());
        }
    }
}
