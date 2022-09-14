package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;

public class SculkSacItem extends Item {

    public SculkSacItem(Properties settings) {
        super(settings);
    }

    public InteractionResultHolder<ItemStack> use(ServerLevel level, ServerPlayer user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!level.isClientSide) {

            if (user.experienceLevel > 0) {
                user.giveExperienceLevels(-7);
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                itemStack.shrink(1);
                user.addItem(new ItemStack(ModItems.FULL_SCULK_SAC, 1));
                level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), SoundEvents.SCULK_BLOCK_CHARGE, SoundSource.NEUTRAL, 1, 1 / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }
}
