package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.entity.ModEntities;
import net.lunarluned.peculia.entity.client.CoalGeodeRenderer;
import net.minecraft.client.render.RenderLayer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PeculiaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.COALGEODE, CoalGeodeRenderer::new);


        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getTranslucent(),

                ModBlocks.MYTHRIL_CRYSTAL

        );
    }
}