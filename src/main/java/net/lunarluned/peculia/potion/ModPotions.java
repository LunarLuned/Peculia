package net.lunarluned.peculia.potion;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion ICHOR_POTION;
    public static Potion EXTICHOR_POTION;
    public static Potion ICHORRESISTANCE_POTION;
    public static Potion EXTICHORRESISTANCE_POTION;

    public static Potion registerIchorPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR, 800, 0)));
    }
    public static Potion registerextIchorPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR, 1600, 0)));
    }

    public static Potion registerIchorResistancePotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR_RESISTANCE, 3600, 0)));
    }
    public static Potion registerextIchorResistancePotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Peculia.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ICHOR_RESISTANCE, 9600, 0)));
    }

    public static void registerIchorPotion() {
        ICHOR_POTION = registerIchorPotion("ichor_potion");
        registerIchorPotionRecipe();
    }
    public static void registerextIchorPotion() {
        EXTICHOR_POTION = registerextIchorPotion("extichor_potion");
        registerextIchorPotionRecipe();
    }
    public static void registerIchorResistancePotion() {ICHORRESISTANCE_POTION = registerIchorResistancePotion("ichor_resistance_potion");
        registerIchorResistancePotionRecipe();
    }
    public static void registerextIchorResistancePotion() { EXTICHORRESISTANCE_POTION = registerextIchorResistancePotion("extichor_resistance_potion");
        registerextIchorResistancePotionRecipe();
    }

    private static void registerIchorPotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.ICHOR,
                ModPotions.ICHOR_POTION);
    }
    private static void registerextIchorPotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.ICHOR_POTION, Items.REDSTONE,
                ModPotions.EXTICHOR_POTION);
    }
    private static void registerIchorResistancePotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.SPORODINE,
                ModPotions.ICHORRESISTANCE_POTION);
    }
    private static void registerextIchorResistancePotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.ICHORRESISTANCE_POTION, Items.REDSTONE,
                ModPotions.EXTICHORRESISTANCE_POTION);
    }
}
