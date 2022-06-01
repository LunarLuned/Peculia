package net.lunarluned.peculia.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> ORE_MYTHRIL_CRYSTAL_PLACED = PlacedFeatures.register("mythril_crystal",
            ModConfiguredFeatures.MYTHRIL_CRYSTAL, ModOreFeatures.modifiersWithCount(1,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-100), YOffset.aboveBottom(20))));
}
