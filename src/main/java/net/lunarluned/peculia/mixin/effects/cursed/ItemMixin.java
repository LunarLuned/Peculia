package net.lunarluned.peculia.mixin.effects.cursed;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At("RETURN"), method = "use", cancellable = true)
    public void use(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        if (player.hasEffect(ModEffects.CURSED)) {
            InteractionResultHolder.fail(player.getItemInHand(interactionHand));
        } else {
            InteractionResultHolder.pass(player.getItemInHand(interactionHand));
            }
    }

    @Inject(at = @At("HEAD"), method = "canAttackBlock", cancellable = true)
    public void canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!player.hasEffect(ModEffects.CURSED)) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }

    @Inject(at = @At("HEAD"), method = "hurtEnemy", cancellable = true)
    public void hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity2, CallbackInfoReturnable<Boolean> cir) {
        if (!livingEntity.hasEffect(ModEffects.CURSED)) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
