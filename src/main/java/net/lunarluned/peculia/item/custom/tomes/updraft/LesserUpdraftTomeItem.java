package net.lunarluned.peculia.item.custom.tomes.updraft;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
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

public class LesserUpdraftTomeItem extends GenericTomeItem {
    public LesserUpdraftTomeItem(Properties settings) {
        super(settings);
    }


    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {

            if (!player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 3) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }
            if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 5) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }

            if (!player.isCrouching() && player.getOffhandItem().getCount() >= 4 && player.getOffhandItem().is(ModItems.SOUL))  {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 29));
                TomeParticles((ServerLevel) level, player);
                player.getOffhandItem().shrink(4);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_UPDRAFT_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
                player.getCooldowns().addCooldown(this, 60);
            }
        }

        // If the player is crouching with souls in their offhand, a levitation cloud will be summoned around them

        if (player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL) && (player.getOffhandItem().getCount() >= 6)) {

            spawnLesserUpdraftCloudAtPos(player, player.getOnPos(), 29);
            spawnLesserUpdraftCloudTwoAtPos(player, player.getOnPos(), 29);
            TomeParticlesCrouching(level, player, player);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_UPDRAFT_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
            player.getOffhandItem().shrink(6);
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0));
            player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
            player.getCooldowns().addCooldown(this, 160);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    // Spawns an updraft cloud at the user's position

    public static void spawnLesserUpdraftCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(5);
        MobEffectInstance levitation = new MobEffectInstance(MobEffects.LEVITATION, 5, amplifier);
        areaEffectCloudEntity.addEffect(levitation);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }

    public static void spawnLesserUpdraftCloudTwoAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(5);
        MobEffectInstance levitation = new MobEffectInstance(MobEffects.LEVITATION, 5, amplifier);
        areaEffectCloudEntity.addEffect(levitation);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
