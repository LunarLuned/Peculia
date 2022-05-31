package net.lunarluned.peculia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.entity.*;
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
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
            if(level == 2) {
                if(world.isRaining()) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
            if(level == 3) {
                if(world.isRaining()) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
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
}
