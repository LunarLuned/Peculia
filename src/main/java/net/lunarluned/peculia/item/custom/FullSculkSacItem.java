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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class FullSculkSacItem extends Item {

    public FullSculkSacItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {

        ItemStack itemStack = user.getItemInHand(hand);

        if (!world.isClientSide) {
            int i = 3 + world.random.nextInt(5) + world.random.nextInt(5);
            ExperienceOrb.award((ServerLevel) world, Vec3.atCenterOf(user.getOnPos()), i);
            itemStack.shrink(1);
            user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), SoundEvents.SCULK_BLOCK_CHARGE, SoundSource.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
    }
}
