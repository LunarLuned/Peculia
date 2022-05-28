package net.lunarluned.peculia.entity.client;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.entity.custom.CoalGeodeEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CoalGeodeModel extends AnimatedGeoModel<CoalGeodeEntity> {
    @Override
    public Identifier getModelResource(CoalGeodeEntity object) {
        return new Identifier(Peculia.MOD_ID, "geo/coalgeode.geo.json");
    }

    @Override
    public Identifier getTextureResource(CoalGeodeEntity object) {
        return new Identifier(Peculia.MOD_ID, "textures/entity/coalgeode/coalgeode.png");
    }

    @Override
    public Identifier getAnimationResource(CoalGeodeEntity animatable) {
        return new Identifier(Peculia.MOD_ID, "animations/coalgeode.animation.json");
    }
    @Override
    public void setLivingAnimations(CoalGeodeEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
