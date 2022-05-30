package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ECHO;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name),
                new EchoEffect(StatusEffectCategory.HARMFUL, 230203));
    }

    public static void registerEffects() {
        ECHO = registerStatusEffect("echo");
    }
}
