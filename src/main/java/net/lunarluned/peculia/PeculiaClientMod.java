package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.misc.ModParticles;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PeculiaClientMod implements ClientModInitializer {

    public static ModelResourceLocation MYTHRIL_HALBERD_INVENTORY = new ModelResourceLocation("peculia:mythril_halberd_inventory#inventory");
    public static ModelResourceLocation MYTHRIL_CLAYMORE_INVENTORY = new ModelResourceLocation("peculia:mythril_claymore_inventory#inventory");
    public static ModelResourceLocation MYTHRIL_HAMMER_INVENTORY = new ModelResourceLocation("peculia:mythril_hammer_inventory#inventory");
    public static ModelResourceLocation MYTHRIL_SCYTHE_INVENTORY = new ModelResourceLocation("peculia:mythril_scythe_inventory#inventory");
    public static ModelResourceLocation MYTHRIL_SPEAREL_INVENTORY = new ModelResourceLocation("peculia:mythril_spearel_inventory#inventory");

    public static ModelResourceLocation TOME_OF_HEALING_INVENTORY = new ModelResourceLocation("peculia:tome_of_healing_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_HEALING_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_healing_inventory#inventory");

    public static ModelResourceLocation TOME_OF_UPDRAFT_INVENTORY = new ModelResourceLocation("peculia:tome_of_updraft_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_UPDRAFT_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_updraft_inventory#inventory");

    public static ModelResourceLocation TOME_OF_EMPOWERING_INVENTORY = new ModelResourceLocation("peculia:tome_of_empowering_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_EMPOWERING_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_empowering_inventory#inventory");

    public static ModelResourceLocation TOME_OF_AGILITY_INVENTORY = new ModelResourceLocation("peculia:tome_of_agility_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_AGILITY_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_agility_inventory#inventory");

    public static ModelResourceLocation TOME_OF_FORTIFYING_INVENTORY = new ModelResourceLocation("peculia:tome_of_fortifying_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_FORTIFYING_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_fortifying_inventory#inventory");

    public static ModelResourceLocation TOME_OF_WATCHING_INVENTORY = new ModelResourceLocation("peculia:tome_of_watching_inventory#inventory");
    public static ModelResourceLocation INVERTED_TOME_OF_WATCHING_INVENTORY = new ModelResourceLocation("peculia:inverted_tome_of_watching_inventory#inventory");



    @Override
    public void onInitializeClient() {
        ModParticles.init();
        ModEntityRenderer.registerRenderers();

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(MYTHRIL_HALBERD_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(MYTHRIL_CLAYMORE_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(MYTHRIL_HAMMER_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(MYTHRIL_SCYTHE_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(MYTHRIL_SPEAREL_INVENTORY));

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_HEALING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_HEALING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_UPDRAFT_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_UPDRAFT_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_EMPOWERING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_EMPOWERING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_AGILITY_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_AGILITY_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_FORTIFYING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_FORTIFYING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(TOME_OF_WATCHING_INVENTORY));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) ->
                out.accept(INVERTED_TOME_OF_WATCHING_INVENTORY));

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