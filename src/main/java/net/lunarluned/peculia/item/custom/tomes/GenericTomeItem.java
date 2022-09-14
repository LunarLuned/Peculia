package net.lunarluned.peculia.item.custom.tomes;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.sound.ModSoundEvents;
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

    public static void flyingPaperOnUse(Level level, Entity entity, Player user) {
        float height = user.getBbHeight();
        if(height * 100 < 100) height = 1.0F;
        else height = height + 0.2F;

        double randomHeight = (double) ((int) height * 10) / 10;
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
