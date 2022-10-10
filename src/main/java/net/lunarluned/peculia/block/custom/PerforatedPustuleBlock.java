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
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.lunarluned.peculia.block.custom.CrumblingBlock.setToAir;

public class PerforatedPustuleBlock extends Block {
    public PerforatedPustuleBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        super.stepOn(level, pos, state, entity);
        if (entity instanceof LivingEntity) {

            level.playSound(null, pos, ModSoundEvents.BLOCK_ICHOR_STICKER_RELEASE, SoundSource.BLOCKS, 1.0f, 1.0f);
            spawnPorousCloudAtPos((LivingEntity) entity, pos, 0);
            setToAir(state, level, pos);
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, pos, state, blockEntity, itemStack);
            level.playSound(null, pos, ModSoundEvents.BLOCK_ICHOR_STICKER_RELEASE, SoundSource.BLOCKS, 1.0f, 1.0f);
            spawnPorousCloudAtPos(player, pos, 0);
            setToAir(state, level, pos);
    }

    public static void spawnPorousCloudAtPos(LivingEntity attacker, BlockPos blockPos, int amplifier){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(attacker.level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setRadius(5.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setDuration(20);
        MobEffectInstance porous = new MobEffectInstance(ModEffects.POROUS, 300, amplifier);
        areaEffectCloudEntity.addEffect(porous);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
}
