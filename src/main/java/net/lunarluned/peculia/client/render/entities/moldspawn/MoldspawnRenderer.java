package net.lunarluned.peculia.client.render.entities.moldspawn;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.client.ModEntityRenderer;
import net.lunarluned.peculia.client.entity.model.MoldspawnModel;
import net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn.MoldspawnEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Environment(value= EnvType.CLIENT)
public class MoldspawnRenderer extends MobRenderer<MoldspawnEntity, MoldspawnModel<MoldspawnEntity>> {

    private static final ResourceLocation NORMAL_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/moldspawn/moldspawn.png");
    private static final ResourceLocation SUS_TEXTURE = new ResourceLocation(Peculia.MOD_ID, "textures/entity/moldspawn/moldspawn_suspicious.png");

    public MoldspawnRenderer(EntityRendererProvider.Context context) {
        super(context, new MoldspawnModel<>(context.bakeLayer(ModEntityRenderer.MOLDSPAWN)), 0.6F);
    }

    protected void setupRotations(MoldspawnEntity moldspawn, @NotNull PoseStack poseStack, float f, float g, float h) {
        if (moldspawn.isSuspicious()) {
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            poseStack.translate(0, 0, -0.5);
        }
        super.setupRotations(moldspawn, poseStack, f, g, h);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull MoldspawnEntity moldspawn) {
        if (moldspawn.isSuspicious()) {
            return SUS_TEXTURE;
        }
        return NORMAL_TEXTURE;
    }
}
