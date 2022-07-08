package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import static net.lunarluned.peculia.block.custom.CrumblingBlock.setToAir;

public class IchorStickerBlock extends Block {
    public IchorStickerBlock(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context){

        return VoxelShapes.union(

                createCuboidShape(4, 2, 4, 12, 4, 12),

                createCuboidShape(7, 0, 8, 9, 2, 8),

                createCuboidShape(8, 0, 7, 8, 2, 9),

                createCuboidShape(5, 4, 5, 11, 8, 11),

                createCuboidShape(4, 4, 4, 12, 9, 12)

                );

        }



        @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if (!entity.isSneaking() && entity.getType() != EntityType.ITEM && entity.getType() != EntityType.EXPERIENCE_BOTTLE && entity.getType() != EntityType.EXPERIENCE_ORB && entity.getType() != EntityType.EVOKER_FANGS && entity.getType() != EntityType.ARROW && entity.getType() != EntityType.ARMOR_STAND && entity.getType() != EntityType.TNT && entity.getType() != EntityType.TNT_MINECART && entity.getType() != EntityType.MINECART && entity.getType() != EntityType.CHEST_MINECART && entity.getType() != EntityType.HOPPER_MINECART && entity.getType() != EntityType.FURNACE_MINECART && entity.getType() != EntityType.COMMAND_BLOCK_MINECART && entity.getType() != EntityType.SPAWNER_MINECART && entity.getType() != EntityType.CHEST_BOAT && entity.getType() != EntityType.BOAT && entity.getType() != EntityType.SNOWBALL && entity.getType() != EntityType.TRIDENT && entity.getType() != EntityType.SPECTRAL_ARROW && entity.getType() != EntityType.EYE_OF_ENDER && entity.getType() != EntityType.FIREWORK_ROCKET && entity.getType() != EntityType.FIREBALL && entity.getType() != EntityType.POTION && entity.getType() != EntityType.SMALL_FIREBALL && entity.getType() != EntityType.DRAGON_FIREBALL && entity.getType() != EntityType.EGG && entity.getType() != EntityType.END_CRYSTAL && entity.getType() != EntityType.PAINTING && entity.getType() != EntityType.ENDER_PEARL && entity.getType() != EntityType.FISHING_BOBBER && entity.getType() != EntityType.FALLING_BLOCK && entity.getType() != EntityType.SHULKER_BULLET && entity.getType() != EntityType.LLAMA_SPIT) {
            world.playSound((PlayerEntity) null, pos, ModSoundEvents.BLOCK_ICHOR_STICKER_RELEASE, SoundCategory.BLOCKS, 1F, 1.0F);
            world.addBlockBreakParticles(pos, state);
            setToAir(state, world, pos);
            LivingEntity livingEntity = ((LivingEntity) entity);
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.ICHOR, 90));
        }
    }
}
