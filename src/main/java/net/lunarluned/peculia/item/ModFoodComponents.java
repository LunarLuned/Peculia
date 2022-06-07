package net.lunarluned.peculia.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;


public class ModFoodComponents {

    public static final FoodComponent POPROCKS = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).snack().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0), 0.4F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent ROCK_CANDY = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.7F).statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0), 0.9F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1.0F).alwaysEdible().build();

}
