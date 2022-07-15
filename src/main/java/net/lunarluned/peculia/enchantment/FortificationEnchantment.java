package net.lunarluned.peculia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

// i already KNOW mostof this enchantment will be mixin.
public class FortificationEnchantment extends Enchantment {
    public FortificationEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
