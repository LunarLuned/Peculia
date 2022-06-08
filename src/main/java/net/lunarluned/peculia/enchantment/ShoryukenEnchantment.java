package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ShoryukenEnchantment extends Enchantment {
    public ShoryukenEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
                ((LivingEntity) target).setVelocity(0,.6,0);
        }
        if (target instanceof PlayerEntity) {
            ((PlayerEntity) target).setVelocity(0,.6,0);
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public boolean isAvailableForRandomSelection() {
        return false;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModGauntletItem;
    }
}
