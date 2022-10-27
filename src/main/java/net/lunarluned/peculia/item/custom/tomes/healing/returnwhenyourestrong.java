package net.lunarluned.peculia.item.custom.tomes.healing;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class returnwhenyourestrong extends GenericTomeItem {
    public returnwhenyourestrong(Properties settings) {
        super(settings);
    }

//this has the answers to the soul cloak only using half of your souls. only return when you have the will to accomplish this task.

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        ItemStack itemStack2 = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack itemStack3 = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack itemStack4 = player.getItemBySlot(EquipmentSlot.LEGS);
        if (!level.isClientSide) {

            if (!player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 1 && !itemStack2.is(ModItems.CLOAK_HELMET) && !itemStack3.is(ModItems.CLOAK_CHESTPLATE) && !itemStack4.is(ModItems.CLOAK_LEGGINGS)) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (player.getOffhandItem().getCount() <= 0 && itemStack2.is(ModItems.CLOAK_HELMET) && itemStack3.is(ModItems.CLOAK_CHESTPLATE) && itemStack4.is(ModItems.CLOAK_LEGGINGS)) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }
            if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 5 && !itemStack2.is(ModItems.CLOAK_HELMET) && !itemStack3.is(ModItems.CLOAK_CHESTPLATE) && !itemStack4.is(ModItems.CLOAK_LEGGINGS)) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (player.getOffhandItem().getCount() <= 3 && itemStack2.is(ModItems.CLOAK_HELMET) && itemStack3.is(ModItems.CLOAK_CHESTPLATE) && itemStack4.is(ModItems.CLOAK_LEGGINGS)) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }

            //if the player does not have the soul cloak on, use normal soul pricing

            if (player.getOffhandItem().getCount() >= 3 && !player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && !itemStack2.is(ModItems.CLOAK_HELMET) && !itemStack3.is(ModItems.CLOAK_CHESTPLATE) && !itemStack4.is(ModItems.CLOAK_LEGGINGS)) {

                player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
                TomeParticles((ServerLevel) level, player);
                player.getOffhandItem().shrink(2);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
                player.getCooldowns().addCooldown(this, 100);
            }
        }

        //if the player does have the soul cloak on, use halfed soul pricing

        if (player.getOffhandItem().getCount() >= 1 && !player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && itemStack2.is(ModItems.CLOAK_HELMET) && itemStack3.is(ModItems.CLOAK_CHESTPLATE) && itemStack4.is(ModItems.CLOAK_LEGGINGS)) {

            player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
            player.getOffhandItem().shrink(1);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
            player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
            player.getCooldowns().addCooldown(this, 100);
        }

        // If the player is crouching with souls in their offhand, a healing cloud will be summoned around them

        if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && (player.getOffhandItem().getCount() >= 6) && !itemStack2.is(ModItems.CLOAK_HELMET) && !itemStack3.is(ModItems.CLOAK_CHESTPLATE) && !itemStack4.is(ModItems.CLOAK_LEGGINGS)) {

            spawnHealingCloudAtPos(player, player.getOnPos(), 1);
            TomeParticlesCrouching(level, player, player);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
            player.getOffhandItem().shrink(6);
            player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
            player.getCooldowns().addCooldown(this, 200);
        }
        if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && (player.getOffhandItem().getCount() >= 3) && itemStack2.is(ModItems.CLOAK_HELMET) && itemStack3.is(ModItems.CLOAK_CHESTPLATE) && itemStack4.is(ModItems.CLOAK_LEGGINGS)) {

            spawnHealingCloudAtPos(player, player.getOnPos(), 1);
            TomeParticlesCrouching(level, player, player);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
            player.getOffhandItem().shrink(6);
            player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
            player.getCooldowns().addCooldown(this, 200);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    // Spawns a healing cloud at the user's position

    public static void spawnHealingCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        MobEffectInstance regeneration = new MobEffectInstance(MobEffects.HEAL, 10, amplifier);
        areaEffectCloudEntity.addEffect(regeneration);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
