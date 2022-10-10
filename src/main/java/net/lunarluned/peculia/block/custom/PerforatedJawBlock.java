package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;


public class PerforatedJawBlock extends Block {
    public PerforatedJawBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLOSED, false));
    }

    public static final BooleanProperty CLOSED = BooleanProperty.create("closed");


    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (entity instanceof LivingEntity && (!(Boolean)state.getValue(CLOSED))) {
            biteEntity(state, level, pos, entity);
        }
    }

    private static void biteEntity(BlockState blockState, Level level, BlockPos pos, @NotNull Entity entity) {
        if (!(Boolean)blockState.getValue(CLOSED)) {
            level.setBlock(pos, blockState.setValue(CLOSED, true), 3);
            entity.hurt(new Peculia.JawDamageSource(), 4.0F);
            level.playSound(null, pos, ModSoundEvents.BLOCK_PERFORATED_JAW_BITE, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(CLOSED);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        if (blockState.getValue(CLOSED)) {
            serverLevel.setBlock(pos, blockState.setValue(CLOSED, false), 3);
            serverLevel.playSound(null, pos, ModSoundEvents.BLOCK_PERFORATED_JAW_OPEN, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLOSED);
    }


}
