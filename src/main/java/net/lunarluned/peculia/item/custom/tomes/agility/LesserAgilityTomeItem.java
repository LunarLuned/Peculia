package net.lunarluned.peculia.item.custom.tomes.agility;

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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class LesserAgilityTomeItem extends GenericTomeItem {
    public LesserAgilityTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!world.isClientSide) {

            if (user.getOffhandItem().is(ModItems.SOUL)) {

                if (!user.isCrouching() && user.getOffhandItem().getCount() <= 6) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (user.isCrouching() && user.getOffhandItem().getCount() <= 7) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                // if player does soul! exist :)

                if (!user.isCrouching() && user.getOffhandItem().getCount() >= 7) {
                    user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 0));
                    user.addEffect(new MobEffectInstance(MobEffects.JUMP, 80, 1));
                    user.getOffhandItem().shrink(7);
                    world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_AGILITY_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getItemInHand(hand).hurtAndBreak(2, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 150);
                }

                // if player soul and crouching, heals around them

                if (user.isCrouching() && user.getOffhandItem().getCount() >= 8) {
                    spawnLesserAgilityCloudAtPos(user, user.getOnPos(), 0);
                    world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_AGILITY_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getOffhandItem().shrink(8);
                    user.getItemInHand(hand).hurtAndBreak(2, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 250);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }


    public static void spawnLesserAgilityCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        MobEffectInstance speed = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, amplifier);
        MobEffectInstance jump_boost = new MobEffectInstance(MobEffects.JUMP, 80, amplifier);
        areaEffectCloudEntity.addEffect(speed);
        areaEffectCloudEntity.addEffect(jump_boost);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
