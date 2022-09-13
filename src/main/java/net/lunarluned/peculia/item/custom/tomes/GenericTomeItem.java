package net.lunarluned.peculia.item.custom.tomes;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class GenericTomeItem extends ModTomeItem {
    public GenericTomeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(ModItems.SOUL).test(ingredient) || super.canRepair(stack, ingredient);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {

            // if player has cursed or doesnt have any souls, item no workie
            if (user.hasStatusEffect(ModEffects.CURSED)) {
                user.emitGameEvent(GameEvent.FLAP);
                return TypedActionResult.fail(itemStack);
            }
            //if player has no souls, play generic tome fail sound
            if (user.isSneaking() && !user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
            if (!user.isSneaking() && !user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public int getEnchantability() {
        return 0;
    }



    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
