package net.lunarluned.peculia.mixin.enchantments;

import net.lunarluned.peculia.item.custom.EchoingMirrorItem;
import net.lunarluned.peculia.item.custom.ModDaggerItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantingDenialMixin {

    // Makes it so that Daggers & Echoing Mirror cannot be enchanted

    @Final
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

        if ((stack.getItem() instanceof ModDaggerItem)) {
            cir.setReturnValue(false);
        }

        if ((stack.getItem() instanceof EchoingMirrorItem)) {
            cir.setReturnValue(false);
        }
    }
}
