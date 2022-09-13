package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.ModPickaxeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ConcussEnchantment extends Enchantment {
    public ConcussEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if(target instanceof LivingEntity) {
            if (user.isCrouching()) {
                ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50 * 2 * level, level - 1));
                ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60 * 2 * level, level - 1));
            }
        }
        super.doPostAttack(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof ModPickaxeItem;
    }
}
