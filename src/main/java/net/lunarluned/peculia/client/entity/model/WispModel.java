package net.lunarluned.peculia.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lunarluned.peculia.client.entity.animations.GhostAnimations;
import net.lunarluned.peculia.client.entity.animations.WispAnimations;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.wisp.WispEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class WispModel<T extends WispEntity> extends HierarchicalModel<T> {

    private final ModelPart Wisp;

    public WispModel(ModelPart root) {
        this.Wisp = root.getChild("Wisp");
    }

    public static LayerDefinition getLayerDefinition() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Wisp = partdefinition.addOrReplaceChild("Wisp", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Wisp.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -2.0F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition Left_Leg = Wisp.addOrReplaceChild("Left_Leg", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, 0.0F));

        PartDefinition Right_Leg = Wisp.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(10, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, 0.0F));

        PartDefinition Left_Arm = Wisp.addOrReplaceChild("Left_Arm", CubeListBuilder.create(), PartPose.offset(3.0F, -7.0F, 0.0F));

        PartDefinition cube_r1 = Left_Arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition Right_Arm = Wisp.addOrReplaceChild("Right_Arm", CubeListBuilder.create(), PartPose.offset(-3.0F, -7.0F, 0.0F));

        PartDefinition cube_r2 = Right_Arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 18).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T wisp, float f, float g, float h, float i, float j) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float k = Math.min((float) wisp.getDeltaMovement().lengthSqr() * 150.0f, 8.0f);
        this.animate(wisp.idleAnimationState, WispAnimations.WISP_IDLE, h);
        this.animate(wisp.walkAnimationState, WispAnimations.WISP_WALK, h);

        this.animate(wisp.danceAnimationState, WispAnimations.WISP_IDLE, h);
        this.animate(wisp.danceAnimationState, WispAnimations.WISP_WALK, h);
    }


    public ModelPart root() {
        return this.Wisp;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Wisp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
