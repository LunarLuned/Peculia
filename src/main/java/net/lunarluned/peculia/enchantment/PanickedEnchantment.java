package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class PanickedEnchantment extends Enchantment {
    protected PanickedEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof PlayerEntity) {
            if (user.getHealth() < 10.0F) {
            user.addStatusEffect(new StatusEffectInstance(ModEffects.PANICKED, 10 * 2 * level, level - 1));
    }
            super.onUserDamaged(user, target, level);
}

    }
    public int getMaxLevel() { return 2; }

    public boolean isTreasure() {
        return true;
    }
}