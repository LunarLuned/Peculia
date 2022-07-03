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
    public static final FoodComponent FUNGAL_STEW = (new FoodComponent.Builder().hunger(14).saturationModifier(8.5F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 0), 0.1F).build());
    public static final FoodComponent MUSHROOM_STEW_TUSK = (new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build());

    //overworld
    public static final FoodComponent SWEET_ROLL = (new FoodComponent.Builder().hunger(3).saturationModifier(2f).snack().statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 40, 0), 0.9F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 500, 0), 0.9F).build());
    public static final FoodComponent HARD_BOILED_EGG = (new FoodComponent.Builder().hunger(2).saturationModifier(4f).snack().build());
}
