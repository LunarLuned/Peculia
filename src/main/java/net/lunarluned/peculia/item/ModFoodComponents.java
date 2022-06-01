package net.lunarluned.peculia.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponent.Builder;


public class ModFoodComponents {

    public static final FoodComponent POPROCKS = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).snack().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0), 0.5F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150, 0), 1.0F).alwaysEdible().build();;
}
