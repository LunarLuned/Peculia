package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.fluid.ModFluids;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PeculiaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getTranslucent(),

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

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SILLTAR_STILL, ModFluids.SILLTAR_FLOWING, new SimpleFluidRenderHandler(
                new Identifier("peculia:block/siltar_still"),
                new Identifier("peculia:block/siltar_flowing"),
                0x61656E
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.SILLTAR_STILL, ModFluids.SILLTAR_FLOWING);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("peculia:block/siltar_still"));
            registry.register(new Identifier("peculia:block/siltar_flowing"));
    });
        //hello acikek.
    }
}