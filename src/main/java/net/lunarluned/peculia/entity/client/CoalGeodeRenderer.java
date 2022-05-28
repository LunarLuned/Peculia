package net.lunarluned.peculia.entity.client;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.entity.custom.CoalGeodeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CoalGeodeRenderer extends GeoEntityRenderer<CoalGeodeEntity> {
    public CoalGeodeRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CoalGeodeModel());
    }

    public Identifier getTextureLocation(CoalGeodeEntity instance) {
        return new Identifier(Peculia.MOD_ID, "textures/entity/coalgeode/coalgeode.png");
    }
}
