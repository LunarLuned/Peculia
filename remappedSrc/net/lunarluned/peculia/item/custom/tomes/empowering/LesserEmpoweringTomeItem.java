package net.lunarluned.peculia.item.custom.tomes.empowering;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.ModTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.World;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class LesserEmpoweringTomeItem extends ModTomeItem {
    public LesserEmpoweringTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!user.level.isClientSide) {

            if (user.hasEffect(ModEffects.CURSED)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_START);
                return InteractionResultHolder.fail(itemStack);
            }

            if (user.getOffhandItem().is(ModItems.SOUL)) {

                if (!user.isCrouching() && user.getOffhandItem().getCount() <= 14) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (user.isCrouching() && user.getOffhandItem().getCount() <= 19) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }

            }

                //if player has no souls, play generic tome fail sound

                if (user.isCrouching() && !user.getOffhandItem().is(ModItems.SOUL)) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (!user.isCrouching() && !user.getOffhandItem().is(ModItems.SOUL)) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
                if (!user.getOffhandItem().is(ModItems.SOUL)) {
                    user.gameEvent(GameEvent.ITEM_INTERACT_START);
                    return InteractionResultHolder.fail(itemStack);

                    // if player does soul! exist :)
                }
                if (!user.isCrouching() && user.getOffhandItem().is(ModItems.SOUL) && user.getOffhandItem().getCount() >= 15) {
                    user.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 200, 0));
                    user.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0));
                    user.getOffhandItem().shrink(15);
                    user.level.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_HEALING_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
                    user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
                    user.getItemCooldownManager().set(this, 800);
                }
                // if player soul and crouching, heals around them
                if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL)) {
                    spawnHealingCloudAtPos(user, user.getBlockPos(), 1);
                    world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_HEALING_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
                    user.getOffHandStack().decrement(20);
                    user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
                    user.getItemCooldownManager().set(this, 300);
                }
            }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    public static void spawnHealingCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        StatusEffectInstance strength = new StatusEffectInstance(StatusEffects.STRENGTH, 400, amplifier);
        StatusEffectInstance determined = new StatusEffectInstance(ModEffects.DETERMINED, 200, amplifier);
        areaEffectCloudEntity.addEffect(strength);
        areaEffectCloudEntity.addEffect(determined);
        attacker.world.spawnEntity(areaEffectCloudEntity);
    }

}
