package net.lunarluned.peculia.block.custom;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class SillBlock extends Block {
    public SillBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
}
