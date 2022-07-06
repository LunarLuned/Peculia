package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CondensedVoidBlock extends Block {
    public CondensedVoidBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.GLASS_BOTTLE)) {
            itemStack.decrement(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            } else if (!player.getInventory().insertStack(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID))) {
                player.dropItem(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID), false);
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        LivingEntity livingEntity = ((LivingEntity) entity);
        livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.VOID_TOUCHED, 200));
        entity.slowMovement(state, new Vec3d(0.8999999761581421D, 3.5D, 0.8999999761581421D));
    }
}
