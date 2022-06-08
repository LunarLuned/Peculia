package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lunarluned.peculia.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.ModelIdentifier;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PeculiaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(MODEL));

        // Renders Blocks in List as Transparent (With Translucency)

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getTranslucent(),

                ModBlocks.MYTHRIL_CRYSTAL,
                ModBlocks.MYTHRIL_BRICKS,
                ModBlocks.MYTHRIL_BRICK_SLAB,
                ModBlocks.MYTHRIL_BRICK_STAIRS,
                ModBlocks.MYTHRIL_BRICK_WALL,
                ModBlocks.POPROCK_CRYSTAL,
                ModBlocks.DRAGONGLASS,
                ModBlocks.DRAGONGLASS_PANE

        );
    }
    public static final ModelIdentifier MODEL = new ModelIdentifier("modid:alternate_model#inventory");

}