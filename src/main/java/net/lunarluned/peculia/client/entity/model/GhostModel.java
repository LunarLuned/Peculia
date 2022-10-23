package net.lunarluned.peculia.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lunarluned.peculia.client.entity.animations.CoalGeodeAnimations;
import net.lunarluned.peculia.client.entity.animations.GhostAnimations;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GhostModel<T extends GhostEntity> extends HierarchicalModel<T> {
    private final ModelPart Ghost;

    public GhostModel(ModelPart root) {
        this.Ghost = root.getChild("Ghost");
    }

    public static LayerDefinition getLayerDefinition() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Ghost = partdefinition.addOrReplaceChild("Ghost", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Ghost.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition Arm_Left = Ghost.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(24, 32).addBox(0.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 32).addBox(0.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(4.0F, -24.0F, 0.0F));

        PartDefinition Arm_Right = Ghost.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 16).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-4.0F, -24.0F, 0.0F));

        PartDefinition Trail = Ghost.addOrReplaceChild("Trail", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition trail_r1 = Trail.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.25F, -1.75F, 8.0F, 9.0F, 4.0F, new CubeDeformation(-0.3F))
                .texOffs(0, 32).addBox(-4.0F, -0.75F, -1.75F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart root() {
        return this.Ghost;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Ghost.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T ghost, float f, float g, float h, float i, float j) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float k = Math.min((float) ghost.getDeltaMovement().lengthSqr() * 150.0f, 8.0f);
        this.animate(ghost.idleAnimationState, GhostAnimations.GHOST_IDLE, h);
        this.animate(ghost.walkAnimationState, GhostAnimations.GHOST_WALK, h);
        this.animate(ghost.hurtAnimationState, GhostAnimations.GHOST_HURT, h);
        this.animate(ghost.fallAnimationState, GhostAnimations.GHOST_FALL, h);
        this.animate(ghost.attackAnimationState, GhostAnimations.GHOST_ATTACK, h);
    }
}
