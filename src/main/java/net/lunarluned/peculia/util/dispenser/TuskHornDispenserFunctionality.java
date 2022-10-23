package net.lunarluned.peculia.util.dispenser;

import net.lunarluned.peculia.misc.ModInstruments;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.*;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;
import java.util.Iterator;
import java.util.Optional;

public class TuskHornDispenserFunctionality implements DispenseItemBehavior {

    public static final TuskHornDispenserFunctionality INSTANCE = new TuskHornDispenserFunctionality();

    private static final String TAG_INSTRUMENT = "instrument";
    public TagKey<Instrument> instruments;

    private Optional<Holder<Instrument>> getInstrument(ItemStack itemStack) {
        ResourceLocation resourceLocation;
        CompoundTag compoundTag = itemStack.getTag();
        if (compoundTag != null && (resourceLocation = ResourceLocation.tryParse(compoundTag.getString(TAG_INSTRUMENT))) != null) {
            return Registry.INSTRUMENT.getHolder(ResourceKey.create(Registry.INSTRUMENT_REGISTRY, resourceLocation));
        }
        Iterator<Holder<Instrument>> iterator = Registry.INSTRUMENT.getTagOrEmpty(this.instruments).iterator();
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        }
        return Optional.empty();
    }

    @Override
    public ItemStack dispense(BlockSource blockSource, @NotNull ItemStack itemStack) {

        Optional<Holder<Instrument>> optional = this.getInstrument(itemStack);
        Level level = blockSource.getLevel();
        BlockPos blockPos = blockSource.getPos().relative(blockSource.getBlockState().getValue(DispenserBlock.FACING));

        if (optional.isPresent()) {

            Instrument instrument = optional.get().value();
            float f = instrument.range() / 16.0f;

            if (optional.get().is(ModInstruments.CRY_TUSK_HORN)) {
                level.playSound(null, blockPos, ModSoundEvents.ITEM_TUSK_HORN_CRY, SoundSource.BLOCKS, f, 1.0f);
            }

            if (optional.get().is(ModInstruments.PULSE_TUSK_HORN)) {
                level.playSound(null, blockPos, ModSoundEvents.ITEM_TUSK_HORN_PULSE, SoundSource.BLOCKS, f, 1.0f);
            }

            if (optional.get().is(ModInstruments.STAMPEDE_TUSK_HORN)) {
                level.playSound(null, blockPos, ModSoundEvents.ITEM_TUSK_HORN_STAMPEDE, SoundSource.BLOCKS, f, 1.0f);
            }
        }
        return itemStack;
    }
}