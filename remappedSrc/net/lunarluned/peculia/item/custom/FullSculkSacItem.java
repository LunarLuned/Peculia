package net.lunarluned.peculia.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class FullSculkSacItem extends Item {

    public FullSculkSacItem(Properties settings) {
        super(settings);
    }

    public InteractionResultHolder<ItemStack> use(Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);

        if (user.level instanceof ServerLevel) {
            int i = 3 + user.level.random.nextInt(5) + user.level.random.nextInt(5);
            ExperienceOrb.award((ServerLevel) user.level, Vec3.atCenterOf(user.getOnPos()), i);
            itemStack.shrink(1);
            user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), SoundEvents.SCULK_BLOCK_CHARGE, SoundSource.NEUTRAL, 0.5F, 0.4F / (user.level.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }
}
