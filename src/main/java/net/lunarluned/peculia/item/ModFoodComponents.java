package net.lunarluned.peculia.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;


public class ModFoodComponents {

    //end
    public static final FoodComponent POPROCKS = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).snack().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0), 0.4F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent ROCK_CANDY = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.7F).statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0), 0.9F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1.0F).alwaysEdible().build();

    //nether
    public static final FoodComponent CRIMSON_STEW = (new FoodComponent.Builder().hunger(8).saturationModifier(7.2F).build());
    public static final FoodComponent WARPED_STEW = (new FoodComponent.Builder().hunger(7).saturationModifier(7.5F).build());
    public static final FoodComponent FUNGAL_STEW = (new FoodComponent.Builder().hunger(12).saturationModifier(8.5F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 140, 0), 0.5F).build());
    public static final FoodComponent MUSHROOM_STEW_TUSK = (new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build());
    public static final FoodComponent SCRAMBLED_EGGS_TUSK = (new FoodComponent.Builder().hunger(6).saturationModifier(7.5F).build());

    //overworld
    public static final FoodComponent SWEET_ROLL = (new FoodComponent.Builder().hunger(3).saturationModifier(2f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0), 0.8F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0), 0.9F).build());
    public static final FoodComponent HARD_BOILED_EGG = (new FoodComponent.Builder().hunger(2).saturationModifier(4f).snack().build());
    public static final FoodComponent SCRAMBLED_EGGS = (new FoodComponent.Builder().hunger(6).saturationModifier(7.5F).build());
    public static final FoodComponent RAW_BACON = (new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 0.7F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 1), 0.7F).build());
    public static final FoodComponent COOKED_BACON = (new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack().build());
    public static final FoodComponent BEEF_PATTY = (new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 0.1F).build());
    public static final FoodComponent COOKED_BEEF_PATTY = (new FoodComponent.Builder().hunger(4).saturationModifier(1f).snack().build());
    public static final FoodComponent BURGER = (new FoodComponent.Builder().hunger(8).saturationModifier(8f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0), 0.9F).build());
    public static final FoodComponent BACON_BURGER = (new FoodComponent.Builder().hunger(10).saturationModifier(10f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 80, 0), 1F).build());

    public static final FoodComponent TOAST = (new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build());

    public static final FoodComponent TOASTED_BREAD = (new FoodComponent.Builder().hunger(5).saturationModifier(1f).build());

    public static final FoodComponent SWEET_BERRY_JAM = (new FoodComponent.Builder().hunger(6).saturationModifier(3f).snack().statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 40, 0), 1F).build());
    public static final FoodComponent APPLE_JAM = (new FoodComponent.Builder().hunger(6).saturationModifier(4f).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0), 1F).build());
    public static final FoodComponent CACTUS_JAM = (new FoodComponent.Builder().hunger(7).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80, 0), 0.7F).build());
    public static final FoodComponent COCOA_SPREAD = (new FoodComponent.Builder().hunger(3).saturationModifier(1f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 0), 1F).build());
    public static final FoodComponent MUSHROOM_PUREE = (new FoodComponent.Builder().hunger(6).saturationModifier(2f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 80, 0), 1F).build());
    public static final FoodComponent PORK_PATE = (new FoodComponent.Builder().hunger(7).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0), .7F).build());

    public static final FoodComponent BERRY_SPREAD_TOAST = (new FoodComponent.Builder().hunger(10).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 70, 0), 0.5F).build());
    public static final FoodComponent APPLE_SPREAD_TOAST = (new FoodComponent.Builder().hunger(10).saturationModifier(7f).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 70, 0), 0.5F).build());
    public static final FoodComponent CACTUS_SPREAD_TOAST = (new FoodComponent.Builder().hunger(10).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 70, 0), 0.1F).build());
    public static final FoodComponent COCOA_SPREAD_TOAST = (new FoodComponent.Builder().hunger(7).saturationModifier(7f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0), 0.6F).build());
    public static final FoodComponent MUSHROOM_SPREAD_TOAST = (new FoodComponent.Builder().hunger(10).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 110, 0), 0.4F).build());
    public static final FoodComponent PORK_SPREAD_TOAST = (new FoodComponent.Builder().hunger(10).saturationModifier(6f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 70, 0), 0.1F).build());
}
