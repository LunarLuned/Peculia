package net.lunarluned.peculia.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class IchorEffect extends StatusEffect {
    public IchorEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.isFrozen()) {
            entity.damage(DamageSource.ON_FIRE, 1.0F);
            entity.setMovementSpeed(-1f);
        }
        if (entity.isFrozen()) {
            entity.removeStatusEffect(ModEffects.ICHOR);
        }
        if (entity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
            entity.removeStatusEffect(ModEffects.ICHOR);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
