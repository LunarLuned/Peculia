package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EmpoweringTomeItem extends Item {
    public EmpoweringTomeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(ModItems.SOUL).test(ingredient) || super.canRepair(stack, ingredient);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {



// if player has cursed, stagnated or doesnt have any souls, item no workie
            if (user.hasStatusEffect(ModEffects.CURSED)) {
                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                return TypedActionResult.fail(itemStack);
            }
            if (user.hasStatusEffect(ModEffects.STAGNATED)) {
                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                return TypedActionResult.fail(itemStack);
            } else if (!user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                return TypedActionResult.fail(itemStack);

                // if player does soul! exist :)
            } else if (!user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL)) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 0));
                user.getOffHandStack().decrement(1);
                user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
                user.getItemCooldownManager().set(this, 100);
            }
            // if player soul and crouching, heals around them
            if (user.isSneaking() && user.getOffHandStack().isOf(ModItems.SOUL)) {
                spawnEmpoweringCloudAtPos(user, user.getBlockPos(), 0);
                user.getOffHandStack().decrement(4);
                user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));
                user.getItemCooldownManager().set(this, 300);
            }
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    public static void spawnEmpoweringCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(attacker.world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(10);
        StatusEffectInstance strength = new StatusEffectInstance(StatusEffects.STRENGTH, 100, amplifier);
        StatusEffectInstance determined = new StatusEffectInstance(ModEffects.DETERMINED, 100, amplifier);
        areaEffectCloudEntity.addEffect(strength);
        areaEffectCloudEntity.addEffect(determined);
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
