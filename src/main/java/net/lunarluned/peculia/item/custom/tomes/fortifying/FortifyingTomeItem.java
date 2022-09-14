package net.lunarluned.peculia.item.custom.tomes.fortifying;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class FortifyingTomeItem extends GenericTomeItem {
    public FortifyingTomeItem(Item.Properties settings) {
        super(settings);
    }


    public InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player user, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = user.getItemInHand(interactionHand);
        if (!user.level.isClientSide) {

            if (!user.isCrouching() && !user.getOffhandItem().is(ModItems.SOUL)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (user.isCrouching() && !user.getOffhandItem().is(ModItems.SOUL)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (user.getOffhandItem().isEmpty()) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (!user.getOffhandItem().is(ModItems.SOUL)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }

            if (!user.isCrouching() && user.getOffhandItem().is(ModItems.SOUL)) {

                if (user.getOffhandItem().getCount() <= 31) {
                    world.gameEvent(user, GameEvent.BLOCK_CHANGE, user.getOnPos());
                    world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }
            if (user.isCrouching() && user.getOffhandItem().is(ModItems.SOUL)) {

                if (user.getOffhandItem().getCount() <= 47) {
                    world.gameEvent(user, GameEvent.BLOCK_CHANGE, user.getOnPos());
                    world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }

            if (user.getOffhandItem().getCount() >= 32) {

                user.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1800, 4, true, true, false));
                user.getOffhandItem().shrink(32);
                world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                user.getItemInHand(interactionHand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(interactionHand));
                user.getCooldowns().addCooldown(this, 1250);
            }
        }

        // If the player is crouching with souls in their offhand, a health boost cloud will be summoned around them

        if (user.isCrouching() && user.getOffhandItem().is(ModItems.SOUL) && (user.getOffhandItem().getCount() >= 48)) {

            spawnHealthBoostCloudAtPos(user, user.getOnPos(), 1);
            world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
            user.getOffhandItem().shrink(48);
            user.getItemInHand(interactionHand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(interactionHand));
            user.getCooldowns().addCooldown(this, 975);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
    }

    // Spawns a health boost cloud at the user's position

    public static void spawnHealthBoostCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        MobEffectInstance health_boost = new MobEffectInstance(MobEffects.HEALTH_BOOST, 1500, amplifier, false, true, false);
        areaEffectCloudEntity.addEffect(health_boost);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }


}
