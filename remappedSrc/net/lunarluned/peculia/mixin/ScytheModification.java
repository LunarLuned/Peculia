package net.lunarluned.peculia.mixin;

import EnchantmentTarget;
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
public abstract class ScytheModification {

    // Mixin to allow Sword Enchants to work on the Scythe

    @Shadow
    @Final
    public EnchantmentTarget type;

    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof KnockbackEnchantment) {
            if (type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof SweepingEnchantment) {
            if (type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof DamageEnchantment) {
            if (type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof FireAspectEnchantment) {
            if (type != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }

        }
    }