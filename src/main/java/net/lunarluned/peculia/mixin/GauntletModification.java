package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.enchantment.ConcussEnchantment;
import net.lunarluned.peculia.enchantment.ThunderingEnchantment;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
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

    // Mixin to allow Concuss to work on Gauntlets

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