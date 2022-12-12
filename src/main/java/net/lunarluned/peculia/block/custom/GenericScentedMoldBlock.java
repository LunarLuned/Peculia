package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.particles.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public abstract class GenericScentedMoldBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public GenericScentedMoldBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }

    public static final VoxelShape SHAPE = Shapes.or((Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D)), Block.box(6, 6, 6, 10, 8, 10), Block.box(5, 8, 5, 11, 10, 11));

    @SuppressWarnings("ALL")
    @Override
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }


    public void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        if (!level.isClientSide && projectile.isOnFire() && this.canBeLit(blockState)) {
            setLit(level, blockState, blockHitResult.getBlockPos(), true);
        }
        level.addParticle(ModParticles.ICHOR_LEAP, blockHitResult.getBlockPos().getX() + .5, blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ() + .5, 0.0, 0.0, 0.0);
        level.playSound(null, blockHitResult.getBlockPos(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0f, 1.0f);

    }

    protected boolean canBeLit(BlockState blockState) {
        return !(Boolean)blockState.getValue(LIT);
    }

    public static void addParticlesAndSound(Level level, BlockPos pos, RandomSource randomSource) {
        float f = randomSource.nextFloat();
        if (f < 0.3F) {
            float k = (0.3F * 0.45F) * (0.2F + 1.0F);
            level.addParticle(ModParticles.ICHOR, (double)pos.getX() + (double) k + .3, (double)pos.getY() + (double) k + .4, (double)pos.getZ() + (double) k + .3, 0.0, 0.10000000149011612, 0.0);
            if (f < 0.17F) {
                level.playLocalSound(pos.getX() + .3, pos.getY() + .3, pos.getZ() + .3, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + randomSource.nextFloat(), randomSource.nextFloat() * 0.7F + 0.3F, false);
            }
            level.addParticle(ParticleTypes.SMALL_FLAME, (double)pos.getX() + (double) k + .5, (double)pos.getY() + (double) k + .3, (double)pos.getZ() + (double) k + .5, 0.0, 0.10000000149011612, 0.0);
        }
    }




    public static void extinguish(@Nullable Player player, BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos) {
        setLit(levelAccessor, blockState, blockPos, false);
        float k = (0.3F * 0.45F) * (0.2F + 1.0F);
        levelAccessor.addParticle(ParticleTypes.SMOKE, (double)blockPos.getX() + (double) k  + .3, (double)blockPos.getY() + (double) k  + .3, (double)blockPos.getZ() + (double) k  + .3, 0.0, 0.10000000149011612, 0.0);
        levelAccessor.playSound(null, blockPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
        levelAccessor.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);


    }

    public static void setLit(LevelAccessor levelAccessor, BlockState blockState, BlockPos blockPos, boolean bl) {
        levelAccessor.setBlock(blockPos, blockState.setValue(LIT, bl), 11);
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }


}
