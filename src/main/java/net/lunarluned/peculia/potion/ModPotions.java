package net.lunarluned.peculia.potion;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion ICHOR_POTION;
    public static Potion EXTICHOR_POTION;

    public static Potion registerIchorPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR, 800, 0)));
    }
    public static Potion registerextIchorPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR, 1600, 0)));
    }

    public static void registerIchorPotion() {
        ICHOR_POTION = registerIchorPotion("ichor_potion");
    }
    public static void registerextIchorPotion() {
        EXTICHOR_POTION = registerextIchorPotion("extichor_potion");
    }
}
