package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RemnantHeartItem extends Item {

    private static final String TAG_OPENED = "Opened";
    private static final String TAG_USABLE = "Usable";

    private static int HEALTH_STORED = 0;

    public RemnantHeartItem(Properties properties) {
        super(properties);
    }

    public static boolean isOpened(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        return compoundTag != null && compoundTag.getBoolean(TAG_OPENED);
    }


    public static boolean isUsable(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        return compoundTag != null && compoundTag.getBoolean(TAG_USABLE);
    }

    public static void AddHealth(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (HEALTH_STORED <= 20 && RemnantHeartItem.isUsable(itemStack)) {
           HEALTH_STORED = HEALTH_STORED + 1;
            player.hurt(new Peculia.SiphoningDamageSource(), 2);
        } else {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.ITEM_GENERIC_TOME_FAIL, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    public static void setOpened(ItemStack itemStack, boolean bl) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putBoolean(TAG_OPENED, bl);
    }

    public static void setUsable(ItemStack itemStack, boolean bl) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putBoolean(TAG_USABLE, bl);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {

        ItemStack itemStack = player.getItemInHand(interactionHand);

        player.awardStat(Stats.ITEM_USED.get(this));

        // A closed Remnant Heart can be opened upon right-clicking

        if (!RemnantHeartItem.isOpened(itemStack)) {

            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.ARMOR_MYTHRIL_EQUIP, SoundSource.PLAYERS, 1.0f, 1.0f);
            RemnantHeartItem.setOpened(itemStack, true);
        }
        if (RemnantHeartItem.isOpened(itemStack)) {
            RemnantHeartItem.setUsable(itemStack, true);
        }

        // The Remnant Heart can be closed when crouching on use

        if ((RemnantHeartItem.isOpened(itemStack)) && (player.isCrouching())) {

            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.ARMOR_MYTHRIL_EQUIP, SoundSource.PLAYERS, 1.0f, 1.0f);
            RemnantHeartItem.setOpened(itemStack, false);
            RemnantHeartItem.setUsable(itemStack, false);
            return InteractionResultHolder.consume(itemStack);

        }

        // If The Remnant Heart is opened & right clicked (without crouching), it'll take some health away and store it in the heart.

        if ((RemnantHeartItem.isOpened(itemStack)) && RemnantHeartItem.isUsable(itemStack) && (!player.isCrouching())) {

            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.ARMOR_MYTHRIL_EQUIP, SoundSource.PLAYERS, 1.0f, 1.0f);
            RemnantHeartItem.AddHealth(level, player, interactionHand);
            return InteractionResultHolder.consume(itemStack);

        }
        return InteractionResultHolder.consume(itemStack);
    }
}
