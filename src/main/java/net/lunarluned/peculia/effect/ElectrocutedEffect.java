package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ElectrocutedEffect extends StatusEffect {
    public ElectrocutedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.isSneaking()){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 250, 1));
            entity.damage(new Peculia.ElectrocutionDamageSource(entity), 1);
            super.applyUpdateEffect(entity, amplifier);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

}
