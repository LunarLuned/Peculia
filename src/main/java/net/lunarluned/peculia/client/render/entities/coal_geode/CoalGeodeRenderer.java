package net.lunarluned.peculia.client.render.entities.coal_geode;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.CoalGeodeModel;
import net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode.CoalGeodeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class CoalGeodeRenderer extends MobRenderer<CoalGeodeEntity, CoalGeodeModel<CoalGeodeEntity>> {

    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/coal_geode/coal_geode.png");

    public CoalGeodeRenderer(EntityRendererProvider.Context context) {
        super(context, new CoalGeodeModel<>(context.bakeLayer(ModEntityRenderer.COAL_GEODE)), 0.6F);
    }


    @Override
    public ResourceLocation getTextureLocation(@NotNull CoalGeodeEntity entity) {
        return NORMAL_TEXTURE;
    }
}
