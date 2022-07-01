package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(LivingEntity.class)

public abstract class LivingEntityMixin {

    @Shadow
    public abstract @Nullable
    StatusEffectInstance getStatusEffect(StatusEffect effect);

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);



        @ModifyVariable(at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"), ordinal = 0,
                method = "applyDamage")

        private float applyVoidTouchedModifier (float amount) {
            if (this.hasStatusEffect(ModEffects.VOID_TOUCHED))
            {
                int level = (this.getStatusEffect(ModEffects.VOID_TOUCHED).getAmplifier() + 1) * 5;
                return amount * 2 - Math.max((amount * (float) (25 - level)) / 25.0f, 0.0f);
            }
                return amount;
    }


}
