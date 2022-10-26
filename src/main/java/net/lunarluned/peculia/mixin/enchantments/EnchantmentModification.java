package net.lunarluned.peculia.mixin.enchantments;

import net.lunarluned.peculia.enchantment.ConcussEnchantment;
import net.lunarluned.peculia.enchantment.ThunderingEnchantment;
import net.lunarluned.peculia.item.custom.*;
import net.lunarluned.peculia.item.custom.scythes.GenericScytheItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentModification {

    // This whole thing is just broken for some reason, so I disabled it for now, hoping it doesn't cause too many issues with it turned off :(
    // - Sydney

    @Shadow @Final public EnchantmentCategory category;

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;

        if ((stack.getItem() instanceof ModDaggerItem)) {
            cir.setReturnValue(false);
        }

        if ((stack.getItem() instanceof EchoingMirrorItem)) {
            cir.setReturnValue(false);
        }

        if (enchantment instanceof ConcussEnchantment) {
            if (category != EnchantmentCategory.DIGGER || !(stack.getItem() instanceof ModGauntletItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof ThunderingEnchantment) {
            if (category != EnchantmentCategory.TRIDENT || !(stack.getItem() instanceof ModAxeItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof KnockbackEnchantment) {
            if (category != EnchantmentCategory.WEAPON || !(stack.getItem() instanceof ModPickaxeItem)) return;
            cir.setReturnValue(true);
        }

        if (enchantment instanceof KnockbackEnchantment) {
            if (category != EnchantmentCategory.WEAPON || !(stack.getItem() instanceof GenericScytheItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof SweepingEdgeEnchantment) {
            if (category != EnchantmentCategory.WEAPON || !(stack.getItem() instanceof GenericScytheItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof DamageEnchantment) {
            if (category != EnchantmentCategory.WEAPON || !(stack.getItem() instanceof GenericScytheItem)) return;
            cir.setReturnValue(true);
        }
        if (enchantment instanceof FireAspectEnchantment) {
            if (category != EnchantmentCategory.WEAPON || !(stack.getItem() instanceof GenericScytheItem)) return;
            cir.setReturnValue(true);
        }
    }
}