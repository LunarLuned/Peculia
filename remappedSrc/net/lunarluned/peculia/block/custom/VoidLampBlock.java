package net.lunarluned.peculia.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class VoidLampBlock extends Block {
    public VoidLampBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    // Particles

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        for(int i = 0; i < 3; ++i) {
            int j = randomSource.nextInt(2) * 2 - 1;
            int k = randomSource.nextInt(2) * 2 - 1;
            double d = (double)blockPos.getX() + 0.5D + 0.25D * (double)j;
            double e = (float)blockPos.getY() + randomSource.nextFloat();
            double f = (double)blockPos.getZ() + 0.5D + 0.25D * (double)k;
            double g = randomSource.nextFloat() * (float)j;
            double h = ((double)randomSource.nextFloat() - 0.5D) * 0.125D;
            double l = randomSource.nextFloat() * (float)k;
            level.addParticle(ParticleTypes.PORTAL, d, e, f, g, h, l);
        }
    }
}
