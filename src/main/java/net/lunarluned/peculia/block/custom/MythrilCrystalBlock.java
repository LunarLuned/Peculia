package net.lunarluned.peculia.block.custom;

import net.minecraft.block.OreBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class MythrilCrystalBlock extends OreBlock {
    public MythrilCrystalBlock(Settings settings, UniformIntProvider uniformIntProvider) {
        super(settings);
    }

    // Allows for the block to be transparent
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) || super.isSideInvisible(state, stateFrom, direction);
    }
}
