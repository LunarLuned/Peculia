package net.lunarluned.peculia.mixin.util;

import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.block.custom.CrumblingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WalkNodeEvaluator.class)
public class WalkNodeEvaluatorMixin {

    @Inject(method = "getBlockPathTypeRaw", at = @At("RETURN"), cancellable = true)
    private static void getBlockPathTypeRaw(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockPathTypes> cir) {

        BlockState blockState = blockGetter.getBlockState(blockPos);

        if (blockState.is(ModBlocks.TITAN_BLOOD) || blockState.is(ModBlocks.ICHOR_STICKER)) {
            cir.setReturnValue(BlockPathTypes.DANGER_FIRE);
        }
        if (blockState.is(ModBlocks.PERFORATED_JAW) || blockState.is(ModBlocks.PERFORATED_PUSTULE) || blockState.getBlock() instanceof CrumblingBlock || blockState.is(ModBlocks.CONDENSED_VOID)) {
            cir.setReturnValue(BlockPathTypes.POWDER_SNOW);
        }
        if (blockState.is(ModBlocks.CHARGED_FERROCK)) {
            cir.setReturnValue(BlockPathTypes.DANGER_OTHER);
        }
    }
}
