package net.lunarluned.peculia.item.custom.tomes.updraft;

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

public class LesserUpdraftTomeItem extends GenericTomeItem {
    public LesserUpdraftTomeItem(Settings settings) {
        super(settings);
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {


            if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 3) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }

            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 5) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }

            // if player does soul! exist :)
        if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 3) {
            user.getOffHandStack().decrement(4);
            user.emitGameEvent(GameEvent.FLAP);
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_UPDRAFT_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5, 29));
            user.getItemCooldownManager().set(this, 60);
        }
        // if player soul and crouching, levitates around them
        if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 5) {

            spawnLesserUpdraftCloudAtPos(user, user.getBlockPos(), 29);
            spawnLesserUpdraftCloudTwoAtPos(user, user.getBlockPos(), 29);
            user.emitGameEvent(GameEvent.FLAP);
            user.getOffHandStack().decrement(6);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60, 0));
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_UPDRAFT_TOME_CROWD_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 160);
        }
    }
            return TypedActionResult.success(itemStack, world.isClient());
        }

    public static void spawnLesserUpdraftCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(5);
        StatusEffectInstance regeneration = new StatusEffectInstance(StatusEffects.LEVITATION, 5, amplifier);
        areaEffectCloudEntity.addEffect(regeneration);
        attacker.world.spawnEntity(areaEffectCloudEntity);
    }
    public static void spawnLesserUpdraftCloudTwoAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(5);
        StatusEffectInstance regeneration = new StatusEffectInstance(StatusEffects.LEVITATION, 5, amplifier);
        areaEffectCloudEntity.addEffect(regeneration);
        attacker.world.spawnEntity(areaEffectCloudEntity);
    }
}
