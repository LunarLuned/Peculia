package net.lunarluned.peculia.client.entity.model;

import net.lunarluned.peculia.client.entity.animations.GhostAnimations;
import net.lunarluned.peculia.client.entity.animations.MoldspawnAnimations;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn.MoldspawnEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MoldspawnModel<T extends MoldspawnEntity> extends HierarchicalModel<T> {

    private final ModelPart root;

    public MoldspawnModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition getLayerDefinition() {

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Moldspawn = partdefinition.addOrReplaceChild("Moldspawn", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Moldspawn.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, -6.5F, 12.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.5F));

        PartDefinition Antenna_Right = Body.addOrReplaceChild("Antenna_Right", CubeListBuilder.create().texOffs(39, 4).addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -3.0F, -6.5F));

        PartDefinition Antenna_Left = Body.addOrReplaceChild("Antenna_Left", CubeListBuilder.create().texOffs(45, 4).mirror().addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, -3.0F, -6.5F));

        PartDefinition Pincer_Right = Body.addOrReplaceChild("Pincer_Right", CubeListBuilder.create(), PartPose.offset(-3.0F, 3.0F, -6.5F));

        PartDefinition Pincer_Right_r1 = Pincer_Right.addOrReplaceChild("Pincer_Right_r1", CubeListBuilder.create().texOffs(-5, 20).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Pincer_Left = Body.addOrReplaceChild("Pincer_Left", CubeListBuilder.create(), PartPose.offset(3.0F, 3.0F, -6.5F));

        PartDefinition Pincer_Left_r1 = Pincer_Left.addOrReplaceChild("Pincer_Left_r1", CubeListBuilder.create().texOffs(-5, 26).mirror().addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Leg_Front_Left = Moldspawn.addOrReplaceChild("Leg_Front_Left", CubeListBuilder.create().texOffs(48, 19).addBox(0.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, -2.5F));

        PartDefinition Leg_Back_Left = Moldspawn.addOrReplaceChild("Leg_Back_Left", CubeListBuilder.create().texOffs(48, 27).addBox(0.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 3.5F));

        PartDefinition Leg_Front_Right = Moldspawn.addOrReplaceChild("Leg_Front_Right", CubeListBuilder.create().texOffs(48, 15).addBox(-6.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, -2.5F));

        PartDefinition Leg_Back_Right = Moldspawn.addOrReplaceChild("Leg_Back_Right", CubeListBuilder.create().texOffs(48, 23).addBox(-6.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 3.5F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T moldspawn, float angle, float distance, float animationProgress, float yaw, float pitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float k = Math.min((float) moldspawn.getDeltaMovement().lengthSqr() * 150.0f, 8.0f);
        this.animate(moldspawn.idleAnimationState, MoldspawnAnimations.MOLDSPAWN_IDLE, animationProgress);
        this.animate(moldspawn.leapAnimationState, MoldspawnAnimations.MOLDSPAWN_LEAP, animationProgress);
        this.animate(moldspawn.biteAnimationState, MoldspawnAnimations.MOLDSPAWN_BITE, animationProgress);
        this.animate(moldspawn.walkAnimationState, MoldspawnAnimations.MOLDSPAWN_WALK, animationProgress, k);
    }

}
