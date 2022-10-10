package net.lunarluned.peculia.mixin.entities.wither;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkull.class)
public class WitherSkullEntityMixin {

    @Inject(at = @At("RETURN"), method = "onHitEntity")
    protected void onHitEntity(EntityHitResult entityHitResult, CallbackInfo ci) {
        if (Peculia.getConfig().mobs.vanillaMobsConfig.witherConfig.stagnated_on_hit) {
            Entity entity = entityHitResult.getEntity();
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.STAGNATED, 120, 0), ((Projectile) (Object) this).getEffectSource());
            }
        }
    }
}
