package net.lunarluned.peculia.block.custom;

import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GenericMultifaceBlock extends MultifaceBlock {

    public GenericMultifaceBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
