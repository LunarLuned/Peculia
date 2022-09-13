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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class LesserFortifyingTomeItem extends GenericTomeItem {
    public LesserFortifyingTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    public InteractionResultHolder<ItemStack> use(Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!user.level.isClientSide) {

            if (user.getOffhandItem().is(ModItems.SOUL)) {

                if (!user.isCrouching() && user.getOffhandItem().getCount() < 30) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (user.isCrouching() && user.getOffhandItem().getCount() < 40) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                // if player does soul! exist :)

                if (!user.isCrouching() && user.getOffhandItem().getCount() >= 30) {
                    user.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 800, 1));
                    user.getOffhandItem().shrink(30);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getItemInHand(hand).hurtAndBreak(2, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 1000);
                }
                // if player soul and crouching, heals around them
                if (user.isCrouching() && user.getOffhandItem().getCount() >= 40) {
                    spawnLesserHealthBoostCloudAtPos(user, user.getOnPos(), 0);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getOffhandItem().shrink(40);
                    user.getItemInHand(hand).hurtAndBreak(2, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 750);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }

    // Spawns a health boost cloud at the user's position

    public static void spawnLesserHealthBoostCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        MobEffectInstance health_boost = new MobEffectInstance(MobEffects.HEALTH_BOOST, 700, amplifier);
        areaEffectCloudEntity.addEffect(health_boost);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
