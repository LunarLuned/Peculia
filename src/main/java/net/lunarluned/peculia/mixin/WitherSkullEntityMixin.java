package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(WitherSkullEntity.class)
public class WitherSkullEntityMixin {

    @Inject(method = "onEntityHit", locals = LocalCapture.CAPTURE_FAILHARD, at =  @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z"))

    private void stagnatedEffectOnHit(EntityHitResult entityHitResult, CallbackInfo ci, Entity entity, Entity entity2, boolean bl, int i) {
        ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(ModEffects.STAGNATED, 120, 0), ((ProjectileEntity) (Object) this).getEffectCause());
    }


}
