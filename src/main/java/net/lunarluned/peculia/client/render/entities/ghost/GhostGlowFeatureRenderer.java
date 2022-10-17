package net.lunarluned.peculia.client.render.entities.ghost;

// The Ghost's glow feature renderer

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.entity.model.GhostModel;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class GhostGlowFeatureRenderer<T extends GhostEntity, M extends GhostModel<T>> extends EyesLayer<T, M> {

    private static final RenderType GHOST_GLOW = RenderType.eyes(new ResourceLocation(Peculia.MOD_ID, "textures/entity/ghost/ghosttrans_e.png"));

    public GhostGlowFeatureRenderer(GhostRenderer featureRendererContext) {
        super((RenderLayerParent<T, M>) featureRendererContext);
    }

    public RenderType renderType() {
        return GHOST_GLOW;
    }
}
