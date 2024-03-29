package net.lunarluned.peculia.item.custom.glyphs;

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
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UpdraftGlyphItem extends Item {


    public UpdraftGlyphItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 25));
                itemStack.shrink(1);
                player.getCooldowns().addCooldown(this, 5);
                level.playSound(null, player.getOnPos().getX(), player.getOnPos().getY(), player.getOnPos().getZ(), ModSoundEvents.ITEM_GENERIC_GLYPH_USE, SoundSource.NEUTRAL, 1, 1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

}
