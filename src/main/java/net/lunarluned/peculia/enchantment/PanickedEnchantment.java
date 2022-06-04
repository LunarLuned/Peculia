package net.lunarluned.peculia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class PanickedEnchantment extends Enchantment {
    protected PanickedEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user instanceof LivingEntity) {
            if (user.getHealth() < 6.0F) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 2 * level, level - 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 2 * level));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20 * 2 * level, level - 1));
    }
            super.onUserDamaged(user, attacker, level);
}

    }
    public int getMaxLevel() { return 2; }
}