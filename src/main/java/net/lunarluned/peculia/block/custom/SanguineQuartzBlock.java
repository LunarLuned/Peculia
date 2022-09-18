package net.lunarluned.peculia.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;



public class SanguineQuartzBlock extends DropExperienceBlock {

    private final IntProvider experienceDropped;

    public SanguineQuartzBlock(Properties settings, IntProvider experienceDropped) {
        super(settings);
        this.experienceDropped = experienceDropped;
    }

    public void spawnAfterBreak(@NotNull BlockState state, @NotNull ServerLevel world, @NotNull BlockPos pos, @NotNull ItemStack stack, boolean dropExperience) {
        super.spawnAfterBreak(state, world, pos, stack, dropExperience);
        if (dropExperience) {
            this.tryDropExperience(world, pos, stack, this.experienceDropped);
        }

    }
}
