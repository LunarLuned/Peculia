package net.lunarluned.peculia.client.render.entities.moldspawn;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.CoalGeodeModel;
import net.lunarluned.peculia.client.entity.model.MoldspawnModel;
import net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode.CoalGeodeEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn.MoldspawnEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class MoldspawnRenderer extends MobRenderer<MoldspawnEntity, MoldspawnModel<MoldspawnEntity>> {

    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/moldspawn/moldspawn.png");

    public MoldspawnRenderer(EntityRendererProvider.Context context) {
        super(context, new MoldspawnModel<>(context.bakeLayer(ModEntityRenderer.MOLDSPAWN)), 0.6F);
    }


    @Override
    public ResourceLocation getTextureLocation(@NotNull MoldspawnEntity entity) {
        return NORMAL_TEXTURE;
    }
}
