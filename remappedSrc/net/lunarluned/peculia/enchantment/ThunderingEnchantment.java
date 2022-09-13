package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ThunderingEnchantment extends Enchantment {
    public ThunderingEnchantment(Rarity weight, EnchantmentCategory type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void doPostAttack(LivingEntity user, @NotNull Entity target, int level) {
        if(!user.level.isClientSide()) {
            ServerLevel world = (ServerLevel) user.level;
            BlockPos position = target.getOnPos();

            if (level == 1) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, 0));
                }
            }
            if(level == 2) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, level - 1));
                }
            }
            if(level == 3) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, level - 1));
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position, MobSpawnType.TRIGGERED, true, true);
                }
            }

        }
        super.doPostAttack(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    public boolean isTradeable() {
        return true;
    }


    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof ModAxeItem;
    }
}
