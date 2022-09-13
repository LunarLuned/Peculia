package net.lunarluned.peculia.item.custom.tomes.healing;

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
import net.minecraft.world.level.gameevent.GameEvent;

public class HealingTomeItem extends GenericTomeItem {
    public HealingTomeItem(Properties settings) {
        super(settings);
    }


    public InteractionResultHolder<ItemStack> use(Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!user.level.isClientSide) {

            if (user.getOffhandItem().is(ModItems.SOUL)) {

                if (!user.isCrouching() && user.getOffhandItem().getCount() <= 4) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                if (user.isCrouching() && user.getOffhandItem().getCount() <= 5) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                // if player does soul! exist :)

                if (!user.isCrouching() && user.getOffhandItem().getCount() >= 3) {
                    user.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
                    user.getOffhandItem().shrink(3);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 100);
                }

                // if player soul and crouching, heals around them

                if (user.isCrouching() && user.getOffhandItem().getCount() >= 6) {
                    spawnHealingCloudAtPos(user, user.getOnPos(), 1);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getOffhandItem().shrink(6);
                    user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 300);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }

    // Spawns a healing cloud at the user's position

    public static void spawnHealingCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
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
