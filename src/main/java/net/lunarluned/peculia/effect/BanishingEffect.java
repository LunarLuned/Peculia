package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.wisp.WispEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BanishingEffect extends MobEffect {
    public BanishingEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof GhostEntity || entity instanceof WispEntity) {
            entity.hurt(DamageSource.MAGIC, 1000.0F);
            }

            super.applyEffectTick(entity, amplifier);
        }
    }
