package net.lunarluned.peculia.mixin.blocks;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.util.dispenser.TuskHornDispenserFunctionality;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DispenserBlock.class)
public abstract class DispenserBlockMixin {

    @Inject(method = "getDispenseMethod", at = @At("HEAD"), cancellable = true)
    private void getDispenseMethod(ItemStack itemStack, CallbackInfoReturnable<DispenseItemBehavior> cir) {

        Item item = itemStack.getItem();

        if (item == ModItems.TUSK_HORN) {
            cir.setReturnValue(TuskHornDispenserFunctionality.INSTANCE);
        }
    }
}