package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EchoingEffect extends StatusEffect {
    public EchoingEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(new Peculia.EchoingMirrorDamageSource(entity), 4.0F);
    }


}
