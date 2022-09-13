package net.lunarluned.peculia.item.custom.tomes.updraft;

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
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import java.util.logging.Level;

public class UpdraftTomeItem extends GenericTomeItem {
    public UpdraftTomeItem(Item.Properties settings) {
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

                if (!user.isCrouching() && user.getOffhandItem().getCount() <= 1) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                if (user.isCrouching() && user.getOffhandItem().getCount() <= 3) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

                // if player does soul! exist :)

                if (!user.isCrouching() && user.getOffhandItem().getCount() >= 2) {
                    user.getOffhandItem().shrink(2);
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_UPDRAFT_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                    user.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 49, false, false, false));
                    user.getCooldowns().addCooldown(this, 40);
                }

                // if player soul and crouching, levitates around them

                if (user.isCrouching() && user.getOffhandItem().getCount() >= 4) {

                    spawnUpdraftCloudAtPos(user, user.getOnPos(), 49);
                    spawnUpdraftCloudTwoAtPos(user, user.getOnPos(), 49);
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.getOffhandItem().shrink(4);
                    user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0));
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_UPDRAFT_TOME_CROWD_USE, SoundSource.NEUTRAL, 1, 1);
                    user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                    user.getCooldowns().addCooldown(this, 120);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }

    // Spawns an updraft cloud at the user's position

    public static void spawnUpdraftCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
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
    public static void spawnUpdraftCloudTwoAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
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
