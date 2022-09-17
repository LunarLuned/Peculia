package net.lunarluned.peculia.item.custom.glyphs;

import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WatchingGlyphItem extends Item {


    public WatchingGlyphItem(Properties properties) {
        super(properties);
    }

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

            for (LivingEntity livingEntity : nearbyEntities) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0, false, false, false));
            }

            for (Player players : nearbyPlayers) {
                players.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 120, 0, false, false, false));
            }
            itemStack.shrink(1);
            player.getCooldowns().addCooldown(this, 5);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_GLYPH_USE, SoundSource.NEUTRAL, 1, 1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

}
