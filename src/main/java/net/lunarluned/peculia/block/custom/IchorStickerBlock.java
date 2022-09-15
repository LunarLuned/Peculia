package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import static net.lunarluned.peculia.block.custom.CrumblingBlock.setToAir;

public class IchorStickerBlock extends Block {
    public IchorStickerBlock(Properties settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Shapes.or(Block.box(4.0D, 2.0D, 4.0D, 12.0D, 7.0D, 12.0D));

    @SuppressWarnings("ALL")
    @Override
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (!entity.isCrouching() && entity instanceof LivingEntity) {
            level.playSound(null, pos, ModSoundEvents.BLOCK_ICHOR_STICKER_RELEASE, SoundSource.BLOCKS, 1.0f, 1.0f);
            spawnIchorCloudAtPos((LivingEntity) entity, pos, 1);
            setToAir(state, level, pos);
        }
    }

    public static void spawnIchorCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(20);
        MobEffectInstance ichor = new MobEffectInstance(ModEffects.ICHOR, 100, amplifier);
        areaEffectCloudEntity.addEffect(ichor);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }




}
