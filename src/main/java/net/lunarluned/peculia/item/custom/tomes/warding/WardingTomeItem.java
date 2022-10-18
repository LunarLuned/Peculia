package net.lunarluned.peculia.item.custom.tomes.warding;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WardingTomeItem extends GenericTomeItem {
    public WardingTomeItem(Properties settings) {
        super(settings);
    }


    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {

            BlockPos blockPos = player.getOnPos();
            int m;
            int l;
            int k = blockPos.getX();
            int j = 16;

            // Scans the area for nearby players

            AABB aABB = new AABB(k, l = blockPos.getY(), m = blockPos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);



            if (!player.isCrouching() && player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 7) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }
                if (!player.isCrouching() && (player.getOffhandItem().getCount() >= 8) && player.getOffhandItem().is(ModItems.SOUL)) {
                    sonicBoom(player, player, 12);
                        for (LivingEntity livingEntity : nearbyEntities)  {
                            livingEntity.hurt(DamageSource.sonicBoom(player), 5.0F);
                        }
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0));
                    player.getCooldowns().addCooldown(this, 100);
                    player.getOffhandItem().shrink(8);
                    TomeParticles((ServerLevel) level, player);
                }
                if (!player.isCrouching() && (player.getOffhandItem().getCount() >= 8) && player.getOffhandItem().is(ModItems.SOUL)) {
                    player.getOffhandItem().shrink(8);
                    TomeParticles((ServerLevel) level, player);
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_WATCHING_TOME_USE, SoundSource.NEUTRAL, 1, 1);
                    player.getCooldowns().addCooldown(this, 100);
                }
            }
            return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
        }

        private static void sonicBoom (LivingEntity attacker, LivingEntity victim,float radius){
            AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(victim.level, victim.getX(), victim.getY() + 0.25f, victim.getZ());
            areaEffectCloudEntity.setOwner(attacker);
            areaEffectCloudEntity.setParticle(ParticleTypes.SONIC_BOOM);
            areaEffectCloudEntity.setRadius(radius);
            areaEffectCloudEntity.setDuration(0);
            attacker.level.addFreshEntity(areaEffectCloudEntity);
        }
    }
