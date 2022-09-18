package net.lunarluned.peculia.mixin.items.misc;

import net.lunarluned.peculia.PeculiaClientMod;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    // Renders separate models for certain items in the inventory and in the entity's hand

    @Shadow
    @Final
    private ItemModelShaper itemModelShaper;

    @ModifyVariable(method = "render", at = @At("HEAD"), argsOnly = true)
    private BakedModel renderGuiModel(BakedModel defaultModel, ItemStack itemStack, ItemTransforms.TransformType transformType) {

        boolean bl2;
        bl2 = transformType == ItemTransforms.TransformType.GUI  || transformType == ItemTransforms.TransformType.FIXED;

        if (bl2) {

            if (itemStack.is(ModItems.TOME_OF_HEALING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_HEALING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_HEALING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_HEALING_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_HEALING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_HEALING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_HEALING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_HEALING_INVENTORY);

            if (itemStack.is(ModItems.TOME_OF_UPDRAFT))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_UPDRAFT_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_UPDRAFT))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_UPDRAFT_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_UPDRAFT))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_UPDRAFT_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_UPDRAFT))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_UPDRAFT_INVENTORY);

            if (itemStack.is(ModItems.TOME_OF_EMPOWERING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_EMPOWERING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_EMPOWERING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_EMPOWERING_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_EMPOWERING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_EMPOWERING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_EMPOWERING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_EMPOWERING_INVENTORY);

            if (itemStack.is(ModItems.TOME_OF_AGILITY))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_AGILITY_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_AGILITY))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_AGILITY_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_AGILITY))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_AGILITY_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_AGILITY))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_AGILITY_INVENTORY);

            if (itemStack.is(ModItems.TOME_OF_FORTIFYING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_FORTIFYING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_FORTIFYING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_FORTIFYING_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_FORTIFYING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_FORTIFYING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_FORTIFYING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_FORTIFYING_INVENTORY);

            if (itemStack.is(ModItems.TOME_OF_WATCHING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_WATCHING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_TOME_OF_WATCHING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.TOME_OF_WATCHING_INVENTORY);
            if (itemStack.is(ModItems.INVERTED_TOME_OF_WATCHING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_WATCHING_INVENTORY);
            if (itemStack.is(ModItems.LESSER_INVERTED_TOME_OF_WATCHING))
                return itemModelShaper.getModelManager().getModel(PeculiaClientMod.INVERTED_TOME_OF_WATCHING_INVENTORY);

        }

        return defaultModel;
    }
}