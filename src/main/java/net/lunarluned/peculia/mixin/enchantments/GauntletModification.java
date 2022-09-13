package net.lunarluned.peculia.mixin.enchantments;

import net.lunarluned.peculia.enchantment.ConcussEnchantment;
import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
@SuppressWarnings("ConstantConditions")
public abstract class GauntletModification {

    // Mixin to allow Concuss to work on Gauntlets

    @Final
    public EnchantmentCategory type;

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof ConcussEnchantment) {
            if (type != EnchantmentCategory.DIGGER || !(stack.getItem() instanceof ModGauntletItem)) return;
            cir.setReturnValue(true);
        }
    }
}