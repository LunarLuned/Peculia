package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ECHO;
    public static StatusEffect ICHOR;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new EchoEffect(StatusEffectCategory.HARMFUL, 15774719));
    }
    public static StatusEffect registerIchorStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new IchorEffect(StatusEffectCategory.HARMFUL, 5704454));
    }


    public static void registerEffects() {
        ECHO = registerStatusEffect("echo");
    }
    public static void registerIchorEffect() {
        ICHOR = registerIchorStatusEffect("ichor");
    }
}
