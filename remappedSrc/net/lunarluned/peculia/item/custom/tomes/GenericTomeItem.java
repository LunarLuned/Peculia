package net.lunarluned.peculia.item.custom.tomes;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class GenericTomeItem extends ModTomeItem {
    public GenericTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!world.isClientSide) {

            // if player has cursed or doesn't have any souls, item no workie :(

            if (user.hasEffect(ModEffects.CURSED)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                return InteractionResultHolder.fail(itemStack);
            }

            // if player has no souls, play generic tome fail sound

            if (!user.getOffhandItem().is(ModItems.SOUL)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }
}
