package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn.MoldspawnEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class IchorResistanceEffect extends MobEffect {
    public IchorResistanceEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof MoldspawnEntity) {
            entity.hurt(DamageSource.MAGIC, 1);
        }
    }
}
