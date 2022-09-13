package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CondensedVoidBlock extends Block {
    public CondensedVoidBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    public InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {

        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(Items.GLASS_BOTTLE)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 2);

            if (itemStack.isEmpty()) {

                player.setItemInHand(hand, new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 2);

            } else if (!player.getInventory().add(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID))) {
                player.drop(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID), false);
                player.hurt(new Peculia.CondensedVoidDamageSource(), 2);
            }
        }
        if (itemStack.is(Items.BOOK)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.INACTIVE_TOME));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            } else if (!player.getInventory().add(new ItemStack(ModItems.INACTIVE_TOME))) {
                player.drop(new ItemStack(ModItems.INACTIVE_TOME), false);
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);
            }
        }

        if (itemStack.is(ModItems.GILDED_MYTHICAL_BLADE)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.VOID_TOUCHED_GILDED_MYTHICAL_BLADE));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);
            }
        }

        if (itemStack.is(ModItems.EMPTY_MIRROR)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.ECHOING_MIRROR));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);
            }
        }

        if (itemStack.is(ModItems.ECHOING_MIRROR)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.ECHOING_MIRROR));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);
            }
        }

        if (itemStack.is(ModItems.MYTHICAL_BLADE)) {

            itemStack.shrink(1);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.BLOCK_CONDENSED_VOID_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(new Peculia.CondensedVoidDamageSource(), 1);

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.VOID_TOUCHED_MYTHICAL_BLADE));
                player.hurt(new Peculia.CondensedVoidDamageSource(), 1);
            }
        }
        return super.use(state, world, pos, player, hand, hit);
    }
    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
        super.entityInside(state, world, pos, entity);
        if (entity instanceof LivingEntity livingEntity && entity.getType() != EntityType.ENDERMAN && entity.getType() != EntityType.ENDERMITE && entity.getType() != EntityType.WITHER) {
            livingEntity.addEffect(new MobEffectInstance(ModEffects.VOID_TOUCHED, 800));
            entity.makeStuckInBlock(state, new Vec3(0.8999999761581421D, 3.5D, 0.8999999761581421D));
        }
    }
}
