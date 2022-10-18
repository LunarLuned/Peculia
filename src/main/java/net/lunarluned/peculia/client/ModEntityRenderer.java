package net.lunarluned.peculia.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.entity.model.CoalGeodeModel;
import net.lunarluned.peculia.client.entity.model.GhostModel;
import net.lunarluned.peculia.client.entity.model.SwordProjectionModel;
import net.lunarluned.peculia.client.entity.model.WispModel;
import net.lunarluned.peculia.client.render.entities.coal_geode.CoalGeodeRenderer;
import net.lunarluned.peculia.client.render.entities.ghost.GhostRenderer;
import net.lunarluned.peculia.client.render.entities.sword_projection.SwordProjectionRenderer;
import net.lunarluned.peculia.client.render.entities.wisp.WispRenderer;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ModEntityRenderer {
    public static final ModelLayerLocation COAL_GEODE = new ModelLayerLocation(new ResourceLocation(Peculia.MOD_ID, "coal_geode"), "main");
    public static final ModelLayerLocation GHOST = new ModelLayerLocation(new ResourceLocation(Peculia.MOD_ID, "ghost"), "main");
    public static final ModelLayerLocation WISP = new ModelLayerLocation(new ResourceLocation(Peculia.MOD_ID, "wisp"), "main");
    public static final ModelLayerLocation SWORD_PROJECTION = new ModelLayerLocation(new ResourceLocation(Peculia.MOD_ID, "sword_projection"), "main");

    public static void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.COAL_GEODE, CoalGeodeRenderer::new);
        EntityRendererRegistry.register(ModEntities.GHOST, GhostRenderer::new);
        EntityRendererRegistry.register(ModEntities.WISP, WispRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWORD_PROJECTION, SwordProjectionRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(COAL_GEODE, CoalGeodeModel::getLayerDefinition);
        EntityModelLayerRegistry.registerModelLayer(GHOST, GhostModel::getLayerDefinition);
        EntityModelLayerRegistry.registerModelLayer(SWORD_PROJECTION, SwordProjectionModel::getLayerDefinition);
        EntityModelLayerRegistry.registerModelLayer(WISP, WispModel::getLayerDefinition);
    }
}

