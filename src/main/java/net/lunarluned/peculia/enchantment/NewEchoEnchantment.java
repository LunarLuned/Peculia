package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.ModSwordItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class NewEchoEnchantment extends Enchantment {
    public NewEchoEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if (user instanceof Player player && player.getRandom().nextInt(100) <= 25) {

        }
    }

    @Override
    public boolean checkCompatibility(@NotNull Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.SHARPNESS;
    }

    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof ModSwordItem;
    }

}