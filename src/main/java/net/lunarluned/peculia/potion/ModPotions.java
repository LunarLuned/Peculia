package net.lunarluned.peculia.potion;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class ModPotions {

    public static Potion ICHOR_POTION;
    public static Potion EXTICHOR_POTION;
    public static Potion ICHORRESISTANCE_POTION;
    public static Potion EXTICHORRESISTANCE_POTION;
    public static Potion DARKNESS_POTION;
    public static Potion EXTDARKNESS_POTION;
    public static Potion BANISHED_POTION;

    public static Potion registerDarknessPotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DARKNESS, 250, 0)));
    }
    public static Potion registerextDarknessPotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DARKNESS, 525, 0)));
    }

    public static Potion registerBanishedPotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
                new Potion(new MobEffectInstance(ModEffects.BANISHING, 40, 0)));
    }

    public static Potion registerIchorPotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(ModEffects.ICHOR, 400, 0)));
    }
    public static Potion registerextIchorPotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(ModEffects.ICHOR, 800, 0)));
    }

    public static Potion registerIchorResistancePotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(ModEffects.ICHOR_RESISTANCE, 3600, 0)));
    }
    public static Potion registerextIchorResistancePotion(String name) {
        return Registry.register(Registry.POTION, new ResourceLocation(Peculia.MOD_ID, name),
        new Potion(new MobEffectInstance(ModEffects.ICHOR_RESISTANCE, 9600, 0)));
    }

    public static void registerIchorPotion() {
        ICHOR_POTION = registerIchorPotion("ichor_potion");
        registerIchorPotionRecipe();
    }
    public static void registerextIchorPotion() {
        EXTICHOR_POTION = registerextIchorPotion("extichor_potion");
        registerextIchorPotionRecipe();
    }
    public static void registerBanishedPotion() {
        BANISHED_POTION = registerBanishedPotion("banished_potion");
    }
    public static void registerDarknessPotion() {
        DARKNESS_POTION = registerDarknessPotion("darkness_potion");
        registerDarknessPotionRecipe();
    }
    public static void registerextDarknessPotion() {
        EXTDARKNESS_POTION = registerextDarknessPotion("extdarkness_potion");
        registerextDarknessPotionRecipe();
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
    private static void registerDarknessPotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.THICK, Items.ECHO_SHARD,
                ModPotions.DARKNESS_POTION);
    }
    private static void registerextDarknessPotionRecipe() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.DARKNESS_POTION, Items.REDSTONE,
                ModPotions.EXTDARKNESS_POTION);
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
