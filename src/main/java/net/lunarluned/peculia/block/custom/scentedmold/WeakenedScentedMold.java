package net.lunarluned.peculia.block.custom.scentedmold;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WeakenedScentedMold extends GenericScentedMoldBlock {

    public WeakenedScentedMold(Properties properties) {
        super(properties);
    }


    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getAbilities().mayBuild && player.getItemInHand(interactionHand).isEmpty() && blockState.getValue(LIT)) {
            extinguish(player, blockState, level, blockPos);
            extinguishscent(blockPos, level);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (player.getAbilities().mayBuild && player.getItemInHand(interactionHand).is(Items.FLINT_AND_STEEL)) {
            setLit(level, blockState, blockHitResult.getBlockPos(), true);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, pos, state, blockEntity, itemStack);
        extinguishscent(pos, level);
        level.playSound(null, pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
        int m;
        int l;
        int k = pos.getX();
        int j = 30;

        if (blockState.getValue(LIT)) {
            addParticlesAndSound(level, pos, randomSource);
            // Scans the area for entities


            AABB aABB = new AABB(k, l = pos.getY(), m = pos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);

            for (LivingEntity livingEntity : nearbyEntities) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0, true, true, true));
            }
        }

    }
    public static void extinguishscent(BlockPos pos, Level level) {

        int m;
        int l;
        int k = pos.getX();
        int j = 60;

        AABB aABB = new AABB(k, l = pos.getY(), m = pos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
        List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);
        for (LivingEntity livingEntity : nearbyEntities) {
            livingEntity.removeEffect(ModEffects.STAGNATED);
        }
    }

}
