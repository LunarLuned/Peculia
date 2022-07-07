package net.lunarluned.peculia.block.custom;

import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;

public class IchorMoldVeinBlock extends MultifaceGrowthBlock {
    public IchorMoldVeinBlock(Settings settings) {
        super(settings);
    }

    @Override
    public LichenGrower getGrower() {
        return null;
    }
}
