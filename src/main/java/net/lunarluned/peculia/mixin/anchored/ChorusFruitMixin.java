package net.lunarluned.peculia.mixin.anchored;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ChorusFruitItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChorusFruitItem.class)
public abstract class ChorusFruitMixin extends Item {

    public ChorusFruitMixin(Item.Properties settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "finishUsingItem")
    public void sicknessUser(ItemStack itemStack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (!level.isClientSide) {
            if (livingEntity.hasEffect(ModEffects.ANCHORED)) {
                livingEntity.hurt(new Peculia.AnchoredDamageSource(), 4);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 360, 0));
            }
        }
    }
}
