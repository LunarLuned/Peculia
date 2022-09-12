package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ChargedFerrockBlock extends Block {
    public ChargedFerrockBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(ModItems.COPPER_CLEAVER)) {
            itemStack.decrement(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            player.damage(new Peculia.ElectrocutionDamageSource(player), 2);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.CHARGED_COPPER_CLEAVER));
                player.damage(new Peculia.ElectrocutionDamageSource(player), 2);
            } else if (!player.getInventory().insertStack(new ItemStack(ModItems.CHARGED_COPPER_CLEAVER))) {
                player.dropItem(new ItemStack(ModItems.CHARGED_COPPER_CLEAVER), false);
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            }
            world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, ModBlocks.FERROCK.getDefaultState(), world, pos));
        }
        if (itemStack.isOf(ModItems.GILDED_COPPER_CLEAVER)) {
            itemStack.decrement(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            player.damage(new Peculia.ElectrocutionDamageSource(player), 2);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            } else if (!player.getInventory().insertStack(new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER))) {
                player.dropItem(new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER), false);
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            }
            world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, ModBlocks.FERROCK.getDefaultState(), world, pos));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
