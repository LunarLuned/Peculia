package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.enchantment.ConcussEnchantment;
import net.lunarluned.peculia.enchantment.ThunderingEnchantment;
import net.lunarluned.peculia.item.custom.ModPickaxeItem;
import net.lunarluned.peculia.item.custom.ModScytheItem;
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
public abstract class ScytheModification {

    // Mixin to allow Concuss & Thundering to work on the Scythe

    @Shadow
    @Final
    public EnchantmentTarget type;

    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof ConcussEnchantment) {
            if (type != EnchantmentTarget.DIGGER || !(stack.getItem() instanceof ModScytheItem)) return;
            if (enchantment instanceof ThunderingEnchantment) {
                if (type != EnchantmentTarget.TRIDENT || !(stack.getItem() instanceof ModScytheItem)) return;
                cir.setReturnValue(true);
            }
        }
    }
}