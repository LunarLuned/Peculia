package net.lunarluned.peculia.item.custom.tomes.updraft;

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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class UpdraftTomeItem extends ModTomeItem {
    public UpdraftTomeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(ModItems.SOUL).test(ingredient) || super.canRepair(stack, ingredient);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {


// if player has cursed or doesnt have any souls, item no workie
            if (user.hasStatusEffect(ModEffects.CURSED)) {
                user.emitGameEvent(GameEvent.FLAP);
                return TypedActionResult.fail(itemStack);
            }

            if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 1) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
            //if player has no souls, play generic tome fail sound
            if (user.isSneaking() && !user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }
            if (!user.isSneaking() && !user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }

            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() <= 3) {
                user.emitGameEvent(GameEvent.FLAP);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundCategory.NEUTRAL, 1, 1);
                return TypedActionResult.fail(itemStack);
            }

            // if player does soul! exist :)
        if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 1) {
            user.getOffHandStack().decrement(2);
            user.emitGameEvent(GameEvent.FLAP);
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_UPDRAFT_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5, 49));
            user.getItemCooldownManager().set(this, 40);
        }
        // if player soul and crouching, levitates around them
        if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL) && user.getOffHandStack().getCount() > 3) {

            spawnUpdraftCloudAtPos(user, user.getBlockPos(), 49);
            spawnUpdraftCloudTwoAtPos(user, user.getBlockPos(), 49);
            user.emitGameEvent(GameEvent.FLAP);
            user.getOffHandStack().decrement(4);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 0));
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_UPDRAFT_TOME_USE, SoundCategory.NEUTRAL, 1, 1);
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 120);
        }
    }
            return TypedActionResult.success(itemStack, world.isClient());
        }

    public static void spawnUpdraftCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
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
    public static void spawnUpdraftCloudTwoAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
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




    @Override
    public int getEnchantability() {
        return 0;
    }



    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
