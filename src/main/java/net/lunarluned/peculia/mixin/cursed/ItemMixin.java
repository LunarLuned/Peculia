package net.lunarluned.peculia.mixin.cursed;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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

    @Inject(at = @At("RETURN"), method = "use")
    public void use(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        if (!player.hasEffect(ModEffects.CURSED)) {
            InteractionResultHolder.fail(interactionHand);
        }
    }

    @Inject(at = @At("HEAD"), method = "canAttackBlock", cancellable = true)
    public void canMine(BlockState blockState, Level level, BlockPos blockPos, Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!player.hasEffect(ModEffects.CURSED)) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
