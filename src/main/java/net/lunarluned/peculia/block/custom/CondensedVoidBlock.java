package net.lunarluned.peculia.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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
            player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            } else if (!player.getInventory().insertStack(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID))) {
                player.dropItem(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID), false);
                player.damage(new Peculia.CondensedVoidDamageSource(player), 2);
            }
        }
        if (itemStack.isOf(ModItems.GILDED_MYTHICAL_BLADE)) {
            itemStack.decrement(1);
            //add a custom sound later asnne
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.VOID_TOUCHED_GILDED_MYTHICAL_BLADE));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 1);
            }
        }
        if (itemStack.isOf(ModItems.EMPTY_MIRROR)) {
            itemStack.decrement(1);
            //add a custom sound later asnne
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.ECHOING_MIRROR));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 1);
            }
        }
        if (itemStack.isOf(ModItems.ECHOING_MIRROR)) {
            itemStack.decrement(1);
            //add a custom sound later asnne
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.ECHOING_MIRROR));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 1);
            }
        }
        if (itemStack.isOf(ModItems.MYTHICAL_BLADE)) {
            itemStack.decrement(1);
            //add a custom sound later asnne
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.VOID_TOUCHED_MYTHICAL_BLADE));
                player.damage(new Peculia.CondensedVoidDamageSource(player), 1);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity.getType() != EntityType.ENDERMAN && entity.getType() != EntityType.ENDERMITE && entity.getType() != EntityType.ITEM && entity.getType() != EntityType.EXPERIENCE_BOTTLE && entity.getType() != EntityType.EXPERIENCE_ORB && entity.getType() != EntityType.EVOKER_FANGS && entity.getType() != EntityType.ARROW && entity.getType() != EntityType.ARMOR_STAND && entity.getType() != EntityType.TNT && entity.getType() != EntityType.TNT_MINECART && entity.getType() != EntityType.MINECART && entity.getType() != EntityType.CHEST_MINECART && entity.getType() != EntityType.HOPPER_MINECART && entity.getType() != EntityType.FURNACE_MINECART && entity.getType() != EntityType.COMMAND_BLOCK_MINECART && entity.getType() != EntityType.SPAWNER_MINECART && entity.getType() != EntityType.CHEST_BOAT && entity.getType() != EntityType.BOAT && entity.getType() != EntityType.SNOWBALL && entity.getType() != EntityType.TRIDENT && entity.getType() != EntityType.SPECTRAL_ARROW && entity.getType() != EntityType.EYE_OF_ENDER && entity.getType() != EntityType.FIREWORK_ROCKET && entity.getType() != EntityType.FIREBALL && entity.getType() != EntityType.POTION && entity.getType() != EntityType.SMALL_FIREBALL && entity.getType() != EntityType.DRAGON_FIREBALL && entity.getType() != EntityType.EGG && entity.getType() != EntityType.END_CRYSTAL && entity.getType() != EntityType.PAINTING && entity.getType() != EntityType.ENDER_PEARL && entity.getType() != EntityType.FISHING_BOBBER && entity.getType() != EntityType.FALLING_BLOCK && entity.getType() != EntityType.SHULKER_BULLET && entity.getType() != EntityType.LLAMA_SPIT) {
            LivingEntity livingEntity = ((LivingEntity) entity);
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.VOID_TOUCHED, 200));
            entity.slowMovement(state, new Vec3d(0.8999999761581421D, 3.5D, 0.8999999761581421D));
        }
    }
}
