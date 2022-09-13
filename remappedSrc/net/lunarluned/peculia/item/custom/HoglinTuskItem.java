package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class HoglinTuskItem extends Item {

    public HoglinTuskItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        super.finishUsingItem(itemStack, level, livingEntity);
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (itemStack.isEmpty()) {
            return new ItemStack(ModItems.HOGLIN_TUSK);
        }
        if (livingEntity instanceof Player player && !((Player)livingEntity).getAbilities().instabuild) {
            ItemStack itemStack2 = new ItemStack(ModItems.HOGLIN_TUSK);
            if (!player.getInventory().add(itemStack2)) {
                player.drop(itemStack2, false);
            }
        }
        return itemStack;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return UseAnim.EAT;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }
}
