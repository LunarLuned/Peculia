package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
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

    public boolean isFoil(@NotNull ItemStack itemStack) {
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player user, @NotNull InteractionHand hand) {

        ItemStack itemStack = user.getItemInHand(hand);

        if (!level.isClientSide) {
            int i = 3 + level.random.nextInt(5) + level.random.nextInt(5);
            ExperienceOrb.award((ServerLevel) level, Vec3.atCenterOf(user.getOnPos()), i);
            itemStack.shrink(1);
            user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            level.playSound(null, user.getOnPos(), ModSoundEvents.SCULK_SAC_EMPTY, SoundSource.NEUTRAL, 1.0f, 0.8f + level.random.nextFloat() * 0.4F);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
