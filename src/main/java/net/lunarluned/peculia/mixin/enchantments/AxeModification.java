package net.lunarluned.peculia.mixin.enchantments;

import net.lunarluned.peculia.enchantment.ThunderingEnchantment;
import net.lunarluned.peculia.item.custom.ModAxeItem;
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
public abstract class AxeModification {

    // Mixin to allow Thundering to work on Axes

    @Final
    public EnchantmentCategory type;

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof ThunderingEnchantment) {
            if (type != EnchantmentCategory.TRIDENT || !(stack.getItem() instanceof ModAxeItem)) return;
            cir.setReturnValue(true);
        }
    }
}