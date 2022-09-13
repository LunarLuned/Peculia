package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class DeterminedEnchantment extends Enchantment {
    protected DeterminedEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void doPostHurt(@NotNull LivingEntity user, @NotNull Entity target, int level) {
        if (user instanceof Player) {

            if (user.getHealth() < 10.0F) {
            user.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 50 * 2 * level, level - 1));
        }

            if (user.hasEffect(ModEffects.DETERMINED)) {
                user.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20 * level,  0));
            }

            super.doPostHurt(user, target, level);
        }
    }
    @Override
    public int getMaxLevel() { return 2; }

    public boolean isTreasureOnly() {
        return true;
    }
}