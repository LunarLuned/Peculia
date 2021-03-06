package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.ModHoeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class LeechingEnchantment extends Enchantment {
    public LeechingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && target.getType() != EntityType.ARMOR_STAND && target.getType() != EntityType.MINECART && target.getType() != EntityType.CHEST_MINECART && target.getType() != EntityType.CHEST_BOAT && target.getType() != EntityType.FURNACE_MINECART && target.getType() != EntityType.HOPPER_MINECART && target.getType() != EntityType.TNT_MINECART && target.getType() != EntityType.WITHER && target.getType() != EntityType.WITHER_SKELETON) {
                if (user instanceof PlayerEntity player && player.getRandom().nextInt(10) <= 5) {
                    if(level == 1) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 80 * level, 0));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40 * level, 0));
                    }

                    if(level == 2) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 60 * level, 0));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80 * level, 1));
                    }

                    if(level == 3) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100 * level, 0));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50 * level, 2));
                    }
                }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return -1.0F + (float)Math.max(0, level - 1) * -0.5F;
    }

    public boolean isAvailableForRandomSelection() {
        return false;
    }
    public boolean isTreasure() {
        return true;
    }
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModHoeItem;
    }

}
