package net.lunarluned.peculia.misc;

import net.lunarluned.peculia.Peculia;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Instrument;

// Tusk Horn Variants

public interface ModInstruments {
    ResourceKey<Instrument> STAMPEDE_TUSK_HORN = ModInstruments.create("stampede_tusk_horn");
    ResourceKey<Instrument> PULSE_TUSK_HORN = ModInstruments.create("pulse_tusk_horn");
    ResourceKey<Instrument> CRY_TUSK_HORN = ModInstruments.create("cry_tusk_horn");

    private static ResourceKey<Instrument> create(String string) {
        return ResourceKey.create(Registry.INSTRUMENT_REGISTRY, new ResourceLocation(Peculia.MOD_ID, string));
    }
}