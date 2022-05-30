package net.lunarluned.peculia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class EvokeEnchantment extends Enchantment {
    public EvokeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            if(!user.world.isClient()) {
                ServerWorld world = (ServerWorld)user.world;
                BlockPos position = target.getBlockPos();

                if(level == 1) {
                    if(world.isRaining()) {
                        EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                                SpawnReason.MOB_SUMMONED, true, true);
                    }
                }
                if(level == 2) {
                        EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                                SpawnReason.MOB_SUMMONED, true, true);
                        EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                                SpawnReason.MOB_SUMMONED, true, true);
                }
                if(level == 3) {
                    EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                            SpawnReason.MOB_SUMMONED, true, true);
                    EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                            SpawnReason.MOB_SUMMONED, true, true);
                    EntityType.EVOKER_FANGS.spawn(world, null, null, null, position,
                            SpawnReason.MOB_SUMMONED, true, true);
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
