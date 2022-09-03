package net.lunarluned.peculia.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CursedEffect extends StatusEffect {
    public CursedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}