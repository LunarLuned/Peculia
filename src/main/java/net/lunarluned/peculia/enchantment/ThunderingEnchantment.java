package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class ThunderingEnchantment extends Enchantment {
    public ThunderingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld)user.world;
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, level - 1));
                }
            }
            if(level == 2) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, level - 1));
                }
            }
            if(level == 3) {
                if(world.isRaining()) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.ELECTROCUTED, 20 * 2 * level, level - 1));
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }

        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean isTreasure() {
        return true;
    }

    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }


    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModAxeItem;
    }
}
