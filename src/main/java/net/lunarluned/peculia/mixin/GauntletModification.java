package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.enchantment.ConcussEnchantment;
import net.lunarluned.peculia.enchantment.EchoEnchantment;
import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.lunarluned.peculia.item.custom.ModHoeItem;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
@SuppressWarnings("ConstantConditions")
public abstract class GauntletModification {

    // Mixin to allow Concuss to work on the Guantlet

    @Shadow
    @Final
    public EnchantmentTarget type;

    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof ConcussEnchantment) {
            if (type != EnchantmentTarget.DIGGER || !(stack.getItem() instanceof ModGauntletItem)) return;
            cir.setReturnValue(true);
        }
        }
    }