package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.common.registry.ModMobTypes;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BlessedEnchantment extends Enchantment {
    public BlessedEnchantment(Rarity rarity, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(rarity, type, slotTypes);
    }



    @Override
    public float getDamageBonus(int i, MobType mobType) {
        if (mobType == ModMobTypes.GHOUL) {
            return 9.0F + (float)i * 2.5F;
        }
        if (mobType == MobType.UNDEAD) {
            return 2.0F + (float)i * 2.5F;
        }
        return 0;
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return !(enchantment instanceof DamageEnchantment);
    }
}

