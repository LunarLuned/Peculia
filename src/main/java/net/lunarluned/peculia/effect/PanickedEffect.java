package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class PanickedEffect extends StatusEffect {
    public PanickedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        super.applyUpdateEffect(entity, amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
