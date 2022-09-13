package net.lunarluned.peculia.item.custom.tomes.healing;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.ModTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class LesserHealingTomeItem extends ModTomeItem {
    public LesserHealingTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {

            if (!player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 7){
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                if (player.getOffhandItem().getCount() <= 9) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                if (player.getOffhandItem().getCount() >= 7) {

                    player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
                    player.getOffhandItem().shrink(7);
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    player.getItemInHand(interactionHand).hurtAndBreak(2, player, p -> p.broadcastBreakEvent(interactionHand));
                    player.getCooldowns().addCooldown(this, 150);
                }
            }

            // If the player is crouching with souls in their offhand, a healing cloud will be summoned around them

            if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && (player.getOffhandItem().getCount() >= 6)) {

                spawnLesserHealingCloudAtPos(player, player.getOnPos(), 0);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
                player.getOffhandItem().shrink(6);
                player.getItemInHand(interactionHand).hurtAndBreak(2, player, p -> p.broadcastBreakEvent(interactionHand));
                player.getCooldowns().addCooldown(this, 350);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    // Spawns a healing cloud at the user's position

    public static void spawnLesserHealingCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        MobEffectInstance regeneration = new MobEffectInstance(MobEffects.HEAL, 0, amplifier);
        areaEffectCloudEntity.addEffect(regeneration);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
