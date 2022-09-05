package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow public abstract boolean isFood();

    @Shadow @Nullable public abstract FoodComponent getFoodComponent();

    @Inject(at = @At("HEAD"), method = "use", cancellable = true)
    public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (!user.hasStatusEffect(ModEffects.CURSED)) {
            if (this.isFood()) {
                ItemStack itemStack = user.getStackInHand(hand);
                if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                    user.setCurrentHand(hand);
                    cir.setReturnValue(TypedActionResult.consume(itemStack));
                } else {
                    cir.setReturnValue(TypedActionResult.fail(itemStack));
                }
            } else {
                cir.setReturnValue(TypedActionResult.pass(user.getStackInHand(hand)));
            }
        } else {
            ItemStack itemStack = user.getStackInHand(hand);
            cir.setReturnValue(TypedActionResult.fail(itemStack));
        }
    }

    @Inject(at = @At("HEAD"), method = "canMine", cancellable = true)
    public void canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner, CallbackInfoReturnable<Boolean> cir) {
        if (!miner.hasStatusEffect(ModEffects.CURSED)) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
