package net.lunarluned.peculia.block.custom;

import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IchorMoldVeinBlock extends MultifaceBlock {

    public IchorMoldVeinBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
