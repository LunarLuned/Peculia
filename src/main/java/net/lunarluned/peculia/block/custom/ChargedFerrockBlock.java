package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ChargedFerrockBlock extends Block {

    public ChargedFerrockBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Entity entity) {

        if (entity instanceof LivingEntity && (!(entity instanceof AbstractGolem))) {
            if (!entity.isSteppingCarefully()) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 20));
            }
        }
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {

        ItemStack itemStack = player.getItemInHand(hand);

        DamageSource electrocution = (new Peculia.ElectrocutionDamageSource(player));

        if (itemStack.is(ModItems.COPPER_CLEAVER)) {

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.CHARGED_COPPER_CLEAVER));

            } else if (!player.getInventory().add(new ItemStack(ModItems.CHARGED_COPPER_CLEAVER))) {

                player.drop(new ItemStack(ModItems.CHARGED_COPPER_CLEAVER), false);

            }
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(electrocution, 2);
            itemStack.shrink(1);
            world.setBlockAndUpdate(pos, pushEntitiesUp(state, ModBlocks.FERROCK.defaultBlockState(), world, pos));
        }

        if (itemStack.is(ModItems.GILDED_COPPER_CLEAVER)) {

            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER));

            } else if (!player.getInventory().add(new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER))) {

                player.drop(new ItemStack(ModItems.CHARGED_GILDED_COPPER_CLEAVER), false);

            }

            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.NEUTRAL, 1.0F, 1.0F);
            player.hurt(electrocution, 2);
            itemStack.shrink(1);
            world.setBlockAndUpdate(pos, pushEntitiesUp(state, ModBlocks.FERROCK.defaultBlockState(), world, pos));
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
