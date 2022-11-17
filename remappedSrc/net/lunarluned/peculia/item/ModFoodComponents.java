package net.lunarluned.peculia.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodComponents {

    // End Foods

    public static final FoodProperties POPROCKS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.12F).fast().effect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.4F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties ROCK_CANDY = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.17F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), 0.9F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F).alwaysEat().build();

    // Nether Foods

    public static final FoodProperties CRIMSON_STEW = (new FoodProperties.Builder().nutrition(8).saturationMod(0.72F).build());
    public static final FoodProperties WARPED_STEW = (new FoodProperties.Builder().nutrition(7).saturationMod(0.75F).build());
    public static final FoodProperties FUNGAL_STEW = (new FoodProperties.Builder().nutrition(12).saturationMod(0.85F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 140, 0), 0.5F).build());
    public static final FoodProperties MUSHROOM_STEW_TUSK = (new FoodProperties.Builder().nutrition(6).saturationMod(0.72F).build());
    public static final FoodProperties SCRAMBLED_EGGS_TUSK = (new FoodProperties.Builder().nutrition(6).saturationMod(0.75F).build());

    // Overworld Foods

    public static final FoodProperties SWEET_ROLL = (new FoodProperties.Builder().nutrition(3).saturationMod(0.2f).fast().effect(new MobEffectInstance(MobEffects.SATURATION, 20, 0), 0.8F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 0), 0.9F).build());
    public static final FoodProperties HARD_BOILED_EGG = (new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).fast().build());
    public static final FoodProperties SCRAMBLED_EGGS = (new FoodProperties.Builder().nutrition(6).saturationMod(0.75F).build());
    public static final FoodProperties RAW_BACON = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 0.7F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.7F).build());
    public static final FoodProperties COOKED_BACON = (new FoodProperties.Builder().nutrition(3).saturationMod(0.1f).fast().build());
    public static final FoodProperties BEEF_PATTY = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 0.1F).build());
    public static final FoodProperties COOKED_BEEF_PATTY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).fast().build());
    public static final FoodProperties BURGER = (new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0), 0.9F).build());
    public static final FoodProperties BACON_BURGER = (new FoodProperties.Builder().nutrition(10).saturationMod(1.0f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0), 1F).build());
    public static final FoodProperties TOAST = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().build());
    public static final FoodProperties TOASTED_BREAD = (new FoodProperties.Builder().nutrition(5).saturationMod(0.1f).build());

    public static final FoodProperties SWEET_BERRY_JAM = (new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).fast().effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0), 1F).build());
    public static final FoodProperties APPLE_JAM = (new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).fast().effect(new MobEffectInstance(MobEffects.REGENERATION, 40, 0), 1F).build());
    public static final FoodProperties CACTUS_JAM = (new FoodProperties.Builder().nutrition(7).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 80, 0), 0.7F).build());
    public static final FoodProperties COCOA_SPREAD = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1f).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0), 1F).build());
    public static final FoodProperties MUSHROOM_PUREE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.2f).fast().effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 80, 0), 1F).build());
    public static final FoodProperties PORK_PATE = (new FoodProperties.Builder().nutrition(7).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0), .7F).build());

    public static final FoodProperties BERRY_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(10).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 70, 0), 0.5F).build());
    public static final FoodProperties APPLE_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(10).saturationMod(0.7f).fast().effect(new MobEffectInstance(MobEffects.REGENERATION, 70, 0), 0.5F).build());
    public static final FoodProperties CACTUS_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(11).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 70, 0), 0.1F).build());
    public static final FoodProperties COCOA_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(7).saturationMod(0.7f).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 0.6F).build());
    public static final FoodProperties MUSHROOM_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(10).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 110, 0), 0.4F).build());
    public static final FoodProperties PORK_SPREAD_TOAST = (new FoodProperties.Builder().nutrition(12).saturationMod(0.6f).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 0), 0.1F).build());
}
