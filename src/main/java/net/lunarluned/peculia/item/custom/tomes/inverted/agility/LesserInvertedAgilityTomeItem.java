package net.lunarluned.peculia.item.custom.tomes.inverted.agility;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LesserInvertedAgilityTomeItem extends GenericTomeItem {
    public LesserInvertedAgilityTomeItem(Properties settings) {
        super(settings);
    }


    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {


            if (!player.isCrouching() && !player.getOffhandItem().is(ModItems.SOUL)) {
                player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (player.isCrouching() && !player.getOffhandItem().is(ModItems.SOUL)) {
                player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (player.getOffhandItem().isEmpty()) {
                player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }
            if (!player.getOffhandItem().is(ModItems.SOUL)) {
                player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                return InteractionResultHolder.fail(itemStack);
            }

            if (!player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 7) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }

            BlockPos blockPos = player.getOnPos();
            int m;
            int l;
            int k = blockPos.getX();
            int j = 10;

            // Scans the area for nearby players

            AABB aABB = new AABB(k, l = blockPos.getY(), m = blockPos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);

            if (!player.isCrouching() && (player.getOffhandItem().getCount() >= 8) && player.getOffhandItem().is(ModItems.SOUL)) {

                for (LivingEntity livingEntity : nearbyEntities) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0, true, true, true));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 0, true, true, true));
                }
                player.getOffhandItem().shrink(8);
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 0, true, true, false));
                TomeParticles((ServerLevel) level, player);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_AGILITY_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), SoundEvents.SOUL_ESCAPE, SoundSource.NEUTRAL, 1, 1);
                player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
                player.getCooldowns().addCooldown(this, 250);
            }
        }


        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
