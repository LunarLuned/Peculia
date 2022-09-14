package net.lunarluned.peculia.item.custom.tomes;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class GenericTomeItem extends ModTomeItem {
    public GenericTomeItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.SOUL);
    }

    public void TomeParticles(ServerLevel level, Player player) {
        ServerLevel serverLevel = level;
        for (int i = 0; i < 5; ++i) {
            serverLevel.sendParticles(ModParticles.FLYING_PAPER, player.getX() + level.random.nextDouble(), player.getY() + 0.8, player.getZ() + level.random.nextDouble(), 2, 0.0, 0.0, 0.0, 0.0);
        }
    }

    // okay. i know this looks BAD but hear me out. this is the only way to get crouching working atm without it killing and softlocking the world. so, sshut up
    public static void TomeParticlesCrouching(Level level, Entity entity, Player user) {
        float height = user.getBbHeight();
        if(height * 100 < 100) height = 1.0F;
        else height = height + 0.2F;

        double randomHeight = (double) ((int) height * 10) / 10;
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
        level.addParticle(ModParticles.FLYING_PAPER, entity.getX(), entity.getY() + 0.2D + randomHeight, entity.getZ(), 0.0, 0.0, 0.0);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!world.isClientSide) {

            // if player has cursed or doesn't have any souls, item no workie :(

            if (user.hasEffect(ModEffects.CURSED)) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                return InteractionResultHolder.fail(itemStack);
            }

        }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());

    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }
}
