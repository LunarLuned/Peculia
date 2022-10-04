package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TuskHornItem extends Item {
    private final TagKey<Instrument> instruments;

    public TuskHornItem(Properties properties, TagKey<Instrument> tagKey) {
        super(properties);
        this.instruments = tagKey;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        Optional<ResourceKey<Instrument>> optional = this.getInstrument(itemStack).flatMap(Holder::unwrapKey);
        if (optional.isPresent()) {
            MutableComponent mutableComponent = Component.translatable(Util.makeDescriptionId("instrument", optional.get().location()));
            list.add(mutableComponent.withStyle(ChatFormatting.GRAY));
        }

    }

    public static ItemStack create(Item item, Holder<Instrument> holder) {
        ItemStack itemStack = new ItemStack(item);
        setSoundVariantId(itemStack, holder);
        return itemStack;
    }

    private static void setSoundVariantId(ItemStack itemStack, Holder<Instrument> holder) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putString("instrument", holder.unwrapKey().orElseThrow(() -> new IllegalStateException("Invalid instrument")).location().toString());
    }

    public void fillItemCategory(@NotNull CreativeModeTab creativeModeTab, @NotNull NonNullList<ItemStack> nonNullList) {
        if (this.allowedIn(creativeModeTab)) {

            for (Holder<Instrument> instrumentHolder : Registry.INSTRUMENT.getTagOrEmpty(this.instruments)) {
                nonNullList.add(create(ModItems.TUSK_HORN, instrumentHolder));
            }
        }
    }

    @SuppressWarnings("ALL")
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Optional<Holder<Instrument>> optional = this.getInstrument(itemStack);
        if (optional.isPresent()) {
            Instrument instrument = (Instrument)((Holder)optional.get()).value();
            player.startUsingItem(interactionHand);
            play(level, player, instrument);
            player.getCooldowns().addCooldown(this, 200);
            return InteractionResultHolder.consume(itemStack);
        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }

    @SuppressWarnings("ALL")
    public int getUseDuration(@NotNull ItemStack itemStack) {
        Optional<Holder<Instrument>> optional = this.getInstrument(itemStack);
        return optional.map(instrumentHolder -> ((Instrument) ((Holder) instrumentHolder).value()).useDuration()).orElse(0);
    }

    private Optional<Holder<Instrument>> getInstrument(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        if (compoundTag != null) {
            ResourceLocation resourceLocation = ResourceLocation.tryParse(compoundTag.getString("instrument"));
            if (resourceLocation != null) {
                return Registry.INSTRUMENT.getHolder(ResourceKey.create(Registry.INSTRUMENT_REGISTRY, resourceLocation));
            }
        }

        Iterator<Holder<Instrument>> iterator = Registry.INSTRUMENT.getTagOrEmpty(this.instruments).iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.empty();
    }

    public UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    private static void play(Level level, Player player, Instrument instrument) {
        SoundEvent soundEvent = instrument.soundEvent();
        float f = instrument.range() / 16.0F;
        level.playSound(player, player, soundEvent, SoundSource.PLAYERS, f, 1.0F);
        level.gameEvent(GameEvent.INSTRUMENT_PLAY, player.position(), GameEvent.Context.of(player));
    }
}