package net.lunarluned.peculia.client.entity.model;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lunarluned.peculia.common.registry.entity.projectiles.SwordProjectionEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SwordProjectionModel<T extends SwordProjectionEntity> extends EntityModel<T> {
	private final ModelPart body;

	public SwordProjectionModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, -24.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -25.0F, 0.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 2).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(-3.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-2.0F, -24.0F, 0.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}