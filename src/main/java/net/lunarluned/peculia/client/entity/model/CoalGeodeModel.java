package net.lunarluned.peculia.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lunarluned.peculia.client.entity.animations.CoalGeodeAnimations;
import net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode.CoalGeodeEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class CoalGeodeModel<T extends CoalGeodeEntity> extends HierarchicalModel<T> {
	private final ModelPart Coal_Geode;

	public CoalGeodeModel(ModelPart root) {
		this.Coal_Geode = root.getChild("Coal_Geode");
	}


	public static LayerDefinition getLayerDefinition() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Coal_Geode = partdefinition.addOrReplaceChild("Coal_Geode", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Body = Coal_Geode.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 3).addBox(0.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, 0.0F));

		PartDefinition Leg_Left = Coal_Geode.addOrReplaceChild("Leg_Left", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 4.0F));

		PartDefinition Leg_Right = Coal_Geode.addOrReplaceChild("Leg_Right", CubeListBuilder.create().texOffs(36, 9).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

		PartDefinition Arm_Left = Coal_Geode.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 5.0F));

		PartDefinition Arm_Right = Coal_Geode.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(36, 15).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull T coal_geode, float f, float g, float h, float i, float j)  {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		float k = Math.min((float) coal_geode.getDeltaMovement().lengthSqr() * 150.0f, 8.0f);
		this.animate(coal_geode.idleAnimationState, CoalGeodeAnimations.COAL_GEODE_IDLE, h);
		this.animate(coal_geode.walkAnimationState, CoalGeodeAnimations.COAL_GEODE_WALK, h, k);
		this.animate(coal_geode.attackAnimationState, CoalGeodeAnimations.COAL_GEODE_ATTACK, h);
		this.animate(coal_geode.feedingAnimationState, CoalGeodeAnimations.COAL_GEODE_FEEDING, h, k);
		this.animate(coal_geode.spitAnimationState, CoalGeodeAnimations.COAL_GEODE_SPIT, h, k);
	}

	public ModelPart root() {
		return this.Coal_Geode;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Coal_Geode.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}