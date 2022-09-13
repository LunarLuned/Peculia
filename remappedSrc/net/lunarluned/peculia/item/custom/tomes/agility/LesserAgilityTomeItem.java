package net.lunarluned.peculia.item.custom.tomes.agility;

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

public class LesserAgilityTomeItem extends GenericTomeItem {
    public LesserAgilityTomeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(ModItems.SOUL).test(ingredient) || super.canRepair(stack, ingredient);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {


            if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 4) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 7) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_CROWD_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
                // if player does soul! exist :)
            if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 4) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 0));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 80, 1));
                user.getOffHandStack().decrement(7);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_HEALING_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
                user.getStackInHand(hand).damage(2, user, p -> p.sendToolBreakStatus(hand));
                user.getItemCooldownManager().set(this, 150);
            }
            // if player soul and crouching, heals around them
            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL)) {
                spawnLesserAgilityCloudAtPos(user, user.getBlockPos(), 0);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_AGILITY_TOME_CROWD_USE, SoundCategory.NEUTRAL, 1, 1);
                user.getOffHandStack().decrement(8);
                user.getStackInHand(hand).damage(2, user, p -> p.sendToolBreakStatus(hand));
                user.getItemCooldownManager().set(this, 200);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    public static void spawnLesserAgilityCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 120, amplifier);
        StatusEffectInstance jump_boost = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 80, amplifier);
        areaEffectCloudEntity.addEffect(speed);
        areaEffectCloudEntity.addEffect(jump_boost);
        attacker.world.spawnEntity(areaEffectCloudEntity);
    }
}
