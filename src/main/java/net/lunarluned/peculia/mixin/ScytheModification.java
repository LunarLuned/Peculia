package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.item.custom.ModHoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
@SuppressWarnings("ConstantConditions")
public abstract class ScytheModification {

    // Mixin to allow Sword Enchants to work on the Scythe

    @Final
    public EnchantmentCategory type;

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof KnockbackEnchantment) {
            if (type != EnchantmentCategory.WEAPON || !(itemStack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof SweepingEdgeEnchantment) {
            if (type != EnchantmentCategory.WEAPON || !(itemStack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof DamageEnchantment) {
            if (type != EnchantmentCategory.WEAPON || !(itemStack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof FireAspectEnchantment) {
            if (type != EnchantmentCategory.WEAPON || !(itemStack.getItem() instanceof ModHoeItem)) return;
            cir.setReturnValue(true);
        }
    }
}