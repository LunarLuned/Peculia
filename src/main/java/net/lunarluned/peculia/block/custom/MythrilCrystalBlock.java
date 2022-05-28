package net.lunarluned.peculia.block.custom;

import net.minecraft.block.TransparentBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public class MythrilCrystalBlock extends TransparentBlock {
    public MythrilCrystalBlock(Settings settings) {
        super(settings);
    }

    // Allows for the block to be transparent
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) || super.isSideInvisible(state, stateFrom, direction);
    }
}
