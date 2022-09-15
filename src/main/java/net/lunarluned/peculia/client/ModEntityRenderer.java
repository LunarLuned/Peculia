package net.lunarluned.peculia.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.entity.model.CoalGeodeModel;
import net.lunarluned.peculia.client.render.entities.coal_geode.CoalGeodeRenderer;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ModEntityRenderer {
    public static final ModelLayerLocation COAL_GEODE = new ModelLayerLocation(new ResourceLocation(Peculia.MOD_ID, "coal_geode"), "main");

    public static void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.COAL_GEODE, CoalGeodeRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(COAL_GEODE, CoalGeodeModel::getLayerDefinition);
    }
}

