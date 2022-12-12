package net.lunarluned.peculia.block.custom;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.minecraft.world.level.block.CandleBlock.CANDLES;


public class WeakenedScentedMold extends GenericScentedMoldBlock {
    public static int LIT_EXTINGUISHER = 0;

    public WeakenedScentedMold(Properties properties) {
        super(properties);
    }


    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getAbilities().mayBuild && player.getItemInHand(interactionHand).isEmpty() && (Boolean) blockState.getValue(LIT)) {
            extinguish(player, blockState, level, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (player.getAbilities().mayBuild && player.getItemInHand(interactionHand).is(Items.FLINT_AND_STEEL)) {
            setLit(level, blockState, blockHitResult.getBlockPos(), true);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
        int m;
        int l;
        int k = pos.getX();
        int j = 30;

        if ((Boolean)blockState.getValue(LIT)) {
            addParticlesAndSound(level, pos, randomSource);
            // Scans the area for entities
            LIT_EXTINGUISHER++;

            AABB aABB = new AABB(k, l = pos.getY(), m = pos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);

            for (LivingEntity livingEntity : nearbyEntities) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 1, false, false, false));
            }
        }
        if (!blockState.getValue(LIT)) {
            if (LIT_EXTINGUISHER == 1) {
                AABB aABB = new AABB(k, l = pos.getY(), m = pos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
                List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);
                for (LivingEntity livingEntity : nearbyEntities) {
                    livingEntity.removeEffect(MobEffects.DIG_SLOWDOWN);
                }
                LIT_EXTINGUISHER--;
            }

        }

    }

}
