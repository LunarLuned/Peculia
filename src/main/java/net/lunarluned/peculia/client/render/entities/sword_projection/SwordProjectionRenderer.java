package net.lunarluned.peculia.client.render.entities.sword_projection;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.SwordProjectionModel;
import net.lunarluned.peculia.common.registry.entity.projectiles.SwordProjectionEntity;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class SwordProjectionRenderer extends EntityRenderer<SwordProjectionEntity> {


    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/sword_projection/sword_projection.png");

    public SwordProjectionRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull SwordProjectionEntity entity) {
        return NORMAL_TEXTURE;
    }
}
