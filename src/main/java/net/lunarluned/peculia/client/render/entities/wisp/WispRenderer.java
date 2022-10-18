package net.lunarluned.peculia.client.render.entities.wisp;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.GhostModel;
import net.lunarluned.peculia.client.entity.model.WispModel;
import net.lunarluned.peculia.client.render.entities.ghost.GhostGlowFeatureRenderer;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.wisp.WispEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class WispRenderer extends MobRenderer<WispEntity, WispModel<WispEntity>> {

    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/wisp/wisp.png");

    public WispRenderer(EntityRendererProvider.Context context) {
        super(context, new WispModel<>(context.bakeLayer(ModEntityRenderer.WISP)), 0.2F);
        this.addLayer(new WispGlowFeatureRenderer<>(this));
    }



    @Override
    public ResourceLocation getTextureLocation(@NotNull WispEntity entity) {
        return NORMAL_TEXTURE;
    }
}
