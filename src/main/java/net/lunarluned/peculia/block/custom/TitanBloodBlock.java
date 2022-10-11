package net.lunarluned.peculia.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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

import static net.lunarluned.peculia.block.custom.CrumblingBlock.setToAir;

public class TitanBloodBlock extends Block {
        public TitanBloodBlock(BlockBehaviour.Properties settings) {
            super(settings);
        }

        public InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {

            ItemStack itemStack = player.getItemInHand(hand);

            if (itemStack.is(Items.GLASS_BOTTLE)) {

                itemStack.shrink(1);
                setToAir(state, world, pos);
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);

                if (itemStack.isEmpty()) {

                    player.setItemInHand(hand, new ItemStack(ModItems.BOTTLE_OF_TITAN_BLOOD));
                    if  (player.getRandom().nextInt(100) <= Peculia.getConfig().blocks.blocksConfig.blockChances.titans_blood_burn_chance) {
                        player.hurt(DamageSource.IN_FIRE, 2);
                        player.setSecondsOnFire(5);
                    }
                } else if (!player.getInventory().add(new ItemStack(ModItems.BOTTLE_OF_TITAN_BLOOD))) {
                    player.drop(new ItemStack(ModItems.BOTTLE_OF_TITAN_BLOOD), false);
                    if  (player.getRandom().nextInt(100) <= Peculia.getConfig().blocks.blocksConfig.blockChances.titans_blood_burn_chance) {
                        player.setSecondsOnFire(5);
                        player.hurt(DamageSource.IN_FIRE, 2);
                    }
                }
            }
            return super.use(state, world, pos, player, hand, hit);
        }
        @Override
        public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
            super.entityInside(state, world, pos, entity);
            if (entity instanceof LivingEntity livingEntity && entity.getType() != EntityType.ENDERMAN && entity.getType() != EntityType.ENDERMITE && entity.getType() != EntityType.WITHER) {
                livingEntity.setSecondsOnFire(10);
                entity.makeStuckInBlock(state, new Vec3(0.8999999761581421D, 3.5D, 0.8999999761581421D));
            }
        }
    }
