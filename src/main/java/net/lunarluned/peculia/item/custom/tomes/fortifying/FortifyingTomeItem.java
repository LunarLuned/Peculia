package net.lunarluned.peculia.item.custom.tomes.fortifying;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FortifyingTomeItem extends GenericTomeItem {
    public FortifyingTomeItem(Settings settings) {
        super(settings);
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {

            if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 31) {
                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 47) {
                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
                // if player does soul! exist :)
        if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 31) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1800, 4));
            user.getOffHandStack().decrement(32);
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_HEALING_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 1250);
        }
        // if player soul and crouching, heals around them
        if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL)) {
            spawnLesserHealthBoostCloudAtPos(user, user.getBlockPos(), 0);
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_HEALING_TOME_CROWD_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getOffHandStack().decrement(48);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 975);
        }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    public static void spawnLesserHealthBoostCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        StatusEffectInstance health_boost = new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1500, amplifier);
        areaEffectCloudEntity.addEffect(health_boost);
        attacker.world.spawnEntity(areaEffectCloudEntity);
    }


}
