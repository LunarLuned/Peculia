package net.lunarluned.peculia.item.custom.elixirs;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GroundedElixirItem extends GenericElixirItem {
    public GroundedElixirItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            serverPlayer.getCooldowns().addCooldown(this, 20);
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            livingEntity.removeEffect(MobEffects.CONFUSION);
            livingEntity.removeEffect(ModEffects.STUNNED);
            livingEntity.removeEffect(MobEffects.LEVITATION);
        }

        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        if (livingEntity instanceof Player player && !((Player)livingEntity).getAbilities().instabuild && !itemStack.isEmpty()) {
            player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
        }
        return itemStack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : itemStack;
    }
}
