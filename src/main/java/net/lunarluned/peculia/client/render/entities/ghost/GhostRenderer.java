package net.lunarluned.peculia.client.render.entities.ghost;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.GhostModel;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Vex;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class GhostRenderer extends MobRenderer<GhostEntity, GhostModel<GhostEntity>> {

    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/ghost/ghosttrans.png");
    private static final ResourceLocation GHOST_ANGERED_TEXTURE = new ResourceLocation("textures/entity/ghost/ghosttrans_angered.png");

    public GhostRenderer(EntityRendererProvider.Context context) {
        super(context, new GhostModel<>(context.bakeLayer(ModEntityRenderer.GHOST)), 0.6F);
        this.addLayer(new GhostGlowFeatureRenderer(this));
    }


    @Override
    public ResourceLocation getTextureLocation(@NotNull GhostEntity entity) {
        if (entity.isAngered()) {
            return GHOST_ANGERED_TEXTURE;
        }
        return NORMAL_TEXTURE;
    }
}
