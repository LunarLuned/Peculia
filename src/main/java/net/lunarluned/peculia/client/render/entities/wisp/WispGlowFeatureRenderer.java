package net.lunarluned.peculia.client.render.entities.wisp;

// The Ghost's glow feature renderer

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.entity.model.GhostModel;
import net.lunarluned.peculia.client.entity.model.WispModel;
import net.lunarluned.peculia.client.render.entities.ghost.GhostRenderer;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.wisp.WispEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class WispGlowFeatureRenderer<T extends WispEntity, M extends WispModel<T>> extends EyesLayer<T, M> {

    private static final RenderType WISP_GLOW = RenderType.eyes(new ResourceLocation(Peculia.MOD_ID, "textures/entity/wisp/wisp_e.png"));

    public WispGlowFeatureRenderer(WispRenderer featureRendererContext) {
        super((RenderLayerParent<T, M>) featureRendererContext);
    }

    public RenderType renderType() {
        return WISP_GLOW;
    }
}
