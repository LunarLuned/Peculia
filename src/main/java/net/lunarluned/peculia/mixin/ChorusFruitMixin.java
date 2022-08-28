package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ChorusFruitItem.class)
public abstract class ChorusFruitMixin extends Item {

    public ChorusFruitMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "finishUsing", cancellable = true)
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if(user.getStatusEffect(ModEffects.ANCHORED) != null)
        {
        }
    }
}
