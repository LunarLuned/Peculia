package net.lunarluned.peculia.client;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.lunarluned.peculia.entity.projectiles.PeculiarSliceEntity;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PeculiarSliceEntityRenderer extends EntityRenderer<PeculiarSliceEntity> {
    protected PeculiarSliceEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    // was gonna work on this, im tired as hell LOL ok night night

    @Override
    public ResourceLocation getTextureLocation(PeculiarSliceEntity entity) {
        return null;
    }
}
