package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.enchantment.ThunderingEnchantment;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.lunarluned.peculia.item.custom.ModPickaxeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
@SuppressWarnings("ConstantConditions")
public abstract class PickaxeModification {

    // Mixin to allow Thundering to work on Axes

    @Shadow
    @Final
    public EnchantmentTarget type;
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof KnockbackEnchantment) {
            if (type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof ModPickaxeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof ThunderingEnchantment) {
            if (type != EnchantmentTarget.TRIDENT || !(stack.getItem() instanceof ModPickaxeItem)) return;
            cir.setReturnValue(true);
        }
    }
}