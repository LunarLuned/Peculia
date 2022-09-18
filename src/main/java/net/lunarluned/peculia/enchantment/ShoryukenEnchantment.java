package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ShoryukenEnchantment extends Enchantment {
    public ShoryukenEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 19, false, false, false));
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof ModGauntletItem;
    }
}
