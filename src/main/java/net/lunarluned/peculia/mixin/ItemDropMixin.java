package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.misc.PeculiaTags;
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

    @Shadow public abstract ItemStack getItem();

    protected ItemDropMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // Detects if an item is in the tag to increase pickup range & make it glow
        if (getItem().is(PeculiaTags.ALERTING_ITEMS)) {
            setGlowingTag(true);
            ignoreExplosion();
            isInvulnerableTo(DamageSource.CACTUS);
            isInvulnerableTo(DamageSource.OUT_OF_WORLD);
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.96D, -1D, 0.96D));
        }

        if (getItem().is(PeculiaTags.SPOOKY_ITEMS)) {

            setNoGravity(true);
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.8D, 0.8D, 0.8D));

        }
    }
}
