package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.scythes.GenericScytheItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class LeechingEnchantment extends Enchantment {
    public LeechingEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if (target instanceof LivingEntity && target.getType() != EntityType.WITHER && target.getType() != EntityType.WITHER_SKELETON) {
                if (user instanceof Player player && player.getRandom().nextInt(10) <= 5) {
                    if (level == 1) {
                        player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 80 * level, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40 * level, 0));
                    }

                    if (level == 2) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60 * level, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80 * level, 1));
                    }

                    if (level == 3) {
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100 * level, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50 * level, 2));
                    }
                }
        }
        super.doPostAttack(user, target, level);
    }

    @Override
    public float getDamageBonus(int level, @NotNull MobType group) {
        return -1.0F + (float)Math.max(0, level - 1) * -0.5F;
    }

    public boolean isDiscoverable() {
        return false;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isTradeable() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof GenericScytheItem;
    }

}
