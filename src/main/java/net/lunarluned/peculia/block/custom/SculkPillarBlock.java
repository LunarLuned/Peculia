package net.lunarluned.peculia.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SculkPillarBlock extends PillarBlock {

    private final IntProvider experienceDropped;

    public SculkPillarBlock(AbstractBlock.Settings settings, IntProvider experience) {
        super(settings);
        this.experienceDropped = experience;
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, stack, this.experienceDropped);
        }

    }
}
