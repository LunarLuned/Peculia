package net.lunarluned.peculia.item.custom.scythes;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JailorsScytheItem extends GenericScytheItem {

    public JailorsScytheItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {

            BlockPos blockPos = player.getOnPos();
            int m;
            int l;
            int k = blockPos.getX();
            int j = 8;

            // Scans the area for nearby players

            AABB aABB = new AABB(k, l = blockPos.getY(), m = blockPos.getZ(), k + 1, l + 1, m + 1).inflate(j).expandTowards(0.0, level.getHeight(), 0.0);
            List<Player> nearbyPlayers = level.getEntitiesOfClass(Player.class, aABB);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, aABB);

            if (player.isCrouching()) {
                for (LivingEntity livingEntity : nearbyEntities) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 100, true, true, true));
                }
                for (Player players : nearbyPlayers) {
                    players.addEffect(new MobEffectInstance(ModEffects.STUNNED, 100, 0, false, false, false));
                }
                level.playSound(null, player.getOnPos(), ModSoundEvents.SCYTHE_STUN, SoundSource.PLAYERS, 1.0f, 0.8f + level.random.nextFloat() * 0.4F);
                player.getItemInHand(interactionHand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(interactionHand));
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                player.removeEffect(ModEffects.STUNNED);
                player.getCooldowns().addCooldown(this, 600);
                return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
            }
        }
        return InteractionResultHolder.pass(itemStack);
    }
}
