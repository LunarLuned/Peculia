package net.lunarluned.peculia.item.custom.glyphs;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EmpoweringGlyphItem extends Item {


    public EmpoweringGlyphItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0));
            player.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 80, 0));
            itemStack.shrink(1);
            player.getCooldowns().addCooldown(this, 5);
            level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_GLYPH_USE, SoundSource.NEUTRAL, 1, 1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

}
