package net.lunarluned.peculia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class MomentumEnchantment extends Enchantment {
    public MomentumEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);



    }



    public int getMaxLevel() { return 1; }
}