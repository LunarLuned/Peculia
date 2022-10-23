package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ElectrocutedEffect extends MobEffect {
    public ElectrocutedEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.isCrouching()){
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 250, 1));
            entity.hurt(new Peculia.ElectrocutionDamageSource(entity), 1);
            super.applyEffectTick(entity, amplifier);
        }
        if (entity.isInWaterOrRain() && !entity.isCrouching()) {
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 250, 1));
            entity.hurt(new Peculia.ElectrocutionDamageSource(entity), 4);
            super.applyEffectTick(entity, amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

}
