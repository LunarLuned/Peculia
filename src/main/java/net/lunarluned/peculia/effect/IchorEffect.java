package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class IchorEffect extends MobEffect {
    public IchorEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.hasEffect(ModEffects.ICHOR_RESISTANCE) || !entity.hasEffect(ModEffects.POROUS)) {
            entity.hurt(new Peculia.IchorDamageSource(), 1.0F + amplifier);
            if ((entity.isFreezing()) || (entity.hasEffect(ModEffects.ICHOR_RESISTANCE) || entity.hasEffect(ModEffects.POROUS))) {
                entity.removeEffect(ModEffects.ICHOR);
            }
            if (entity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                entity.removeEffect(ModEffects.ICHOR);
                entity.removeEffect(MobEffects.FIRE_RESISTANCE);
            }
            super.applyEffectTick(entity, amplifier);
        }
    }
}
