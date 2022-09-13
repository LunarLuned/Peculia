package net.lunarluned.peculia.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrumblingBlock extends Block {
    public CrumblingBlock(Properties settings) {
        super(settings);
    }

    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        if (entity instanceof LivingEntity) {
            setToAir(state, level, pos);
            super.stepOn(level, pos, state, entity);

            level.playSound(null, pos, SoundEvents.NETHERRACK_BREAK, SoundSource.BLOCKS, 1F, 1.0F);
            level.levelEvent(null, 2001, pos, getId(state));
        }
    }

    public static void setToAir(BlockState state, Level world, BlockPos pos) {
        world.setBlockAndUpdate(pos, pushEntitiesUp(state, Blocks.AIR.defaultBlockState(), world, pos));
    }
}
