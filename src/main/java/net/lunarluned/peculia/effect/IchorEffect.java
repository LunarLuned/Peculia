package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
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
        if (!entity.hasStatusEffect(ModEffects.ICHOR_RESISTANCE)) {
            entity.damage(new Peculia.IchorDamageSource(entity), 1.0F + amplifier);
        }
        if (entity.isFrozen() ) {
            entity.removeStatusEffect(ModEffects.ICHOR);
        }
        if (entity.hasStatusEffect(ModEffects.ICHOR_RESISTANCE)) {
            entity.removeStatusEffect(ModEffects.ICHOR);
        }
        if (entity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
            entity.removeStatusEffect(ModEffects.ICHOR);
            entity.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
