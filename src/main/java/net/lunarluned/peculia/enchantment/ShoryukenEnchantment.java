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
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ShoryukenEnchantment extends Enchantment {
    public ShoryukenEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            target.addVelocity(0, (level / 6.0f) * (1.0D - ((LivingEntity) (target)).getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE) * 0.5), 0);
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModGauntletItem;
    }
}
