package net.lunarluned.peculia.item.custom.tomes.harvesting;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.tomes.GenericTomeItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HarvestingTomeItem extends GenericTomeItem {
    public HarvestingTomeItem(Properties settings) {
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
            List<Mob> nearbyEntities = level.getEntitiesOfClass(Mob.class, aABB);



            if (player.getOffhandItem().is(ModItems.SOUL)) {

                if (player.getOffhandItem().getCount() <= 7) {
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, player.getOnPos());
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.NEUTRAL, 1, 1);
                    return InteractionResultHolder.fail(itemStack);
                }
            }
                if ((player.getOffhandItem().getCount() >= 8) && player.getOffhandItem().is(ModItems.SOUL)) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0));
                    player.getCooldowns().addCooldown(this, 100);
                    player.getOffhandItem().shrink(8);
                    TomeParticles((ServerLevel) level, player);
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 3));
                    level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_HARVESTING_TOME_USE, SoundSource.NEUTRAL, 1, 1);

                    harvestingBoom(player, player, 12);
                    boom(player, player, 12);
                    for (LivingEntity livingEntity : nearbyEntities)  {
                        livingEntity.hurt(DamageSource.MAGIC, 16.0F);
                    }
                }
            }
            return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
        }

        private static void harvestingBoom (LivingEntity attacker, LivingEntity victim,float radius){
            AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(victim.level, victim.getX(), victim.getY() + 0.35f, victim.getZ());
            areaEffectCloudEntity.setOwner(attacker);
            areaEffectCloudEntity.setParticle(ParticleTypes.SOUL);
            areaEffectCloudEntity.setRadius(radius);
            areaEffectCloudEntity.setDuration(0);
            attacker.level.addFreshEntity(areaEffectCloudEntity);
        }
    private static void boom (LivingEntity attacker, LivingEntity victim,float radius){
        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(victim.level, victim.getX(), victim.getY() - 0.35f, victim.getZ());
        areaEffectCloudEntity.setOwner(attacker);
        areaEffectCloudEntity.setParticle(ParticleTypes.EXPLOSION);
        areaEffectCloudEntity.setRadius(radius);
        areaEffectCloudEntity.setDuration(0);
        attacker.level.addFreshEntity(areaEffectCloudEntity);
    }
    }
