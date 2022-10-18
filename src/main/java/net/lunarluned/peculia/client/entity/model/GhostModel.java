package net.lunarluned.peculia.client.entity.model;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.entity.animations.GhostAnimations;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GhostModel<T extends GhostEntity> extends HierarchicalModel<T> {

    private final ModelPart head;
    private final ModelPart root;

    public GhostModel(ModelPart root) {
        this.root = root;
        ModelPart body = root.getChild("Body");
        this.head = body.getChild("Head");
    }

    public static LayerDefinition getLayerDefinition() {

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("Ghost", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
        .texOffs(0, 48).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

        partdefinition.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(24, 32).addBox(0.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 32).addBox(0.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(4.0F, -24.0F, 0.0F));

        partdefinition.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 16).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-4.0F, -24.0F, 0.0F));

        PartDefinition Trail = partdefinition.addOrReplaceChild("Trail", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

        Trail.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.25F, -1.75F, 8.0F, 9.0F, 4.0F, new CubeDeformation(-0.3F))
                .texOffs(0, 32).addBox(-4.0F, -0.75F, -1.75F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T ghost, float angle, float distance, float animationProgress, float yaw, float pitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.root.setPos(0.0f, 23.0f, 0.0f);
        this.head.yRot = yaw * 0.017453292F;
        float k = Math.min((float) ghost.getDeltaMovement().lengthSqr() * 150.0f, 8.0f);
        this.animate(ghost.idleAnimationState, GhostAnimations.GHOST_IDLE, animationProgress);
        this.animate(ghost.attackAnimationState, GhostAnimations.GHOST_ATTACK, animationProgress);
    }
}
