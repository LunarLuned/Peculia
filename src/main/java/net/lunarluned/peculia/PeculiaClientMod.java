package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lunarluned.peculia.block.ModBlocks;
import net.minecraft.client.renderer.RenderType;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PeculiaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.translucent(),

                ModBlocks.ICHOR_MOLD_VEIN,
                ModBlocks.ICHOR_STICKER,
                ModBlocks.MYTHRIL_CRYSTAL,
                ModBlocks.MYTHRIL_BRICKS,
                ModBlocks.MYTHRIL_BRICK_SLAB,
                ModBlocks.MYTHRIL_BRICK_STAIRS,
                ModBlocks.MYTHRIL_BRICK_WALL,
                ModBlocks.POPROCK_CRYSTAL,
                ModBlocks.POPROCK_BRICKS,
                ModBlocks.POPROCK_BRICK_SLAB,
                ModBlocks.POPROCK_BRICK_STAIRS,
                ModBlocks.POPROCK_BRICK_WALL,
                ModBlocks.CHISELED_POPROCK_BRICKS,
                ModBlocks.DRAGONGLASS,
                ModBlocks.DRAGONGLASS_PANE

        );
        //hello acikek.
    }
}