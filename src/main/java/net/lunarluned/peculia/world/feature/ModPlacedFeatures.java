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

    public static final RegistryEntry<PlacedFeature> ORE_POPROCK_CRYSTAL_PLACED = PlacedFeatures.register("poprock_crystal",
            ModConfiguredFeatures.POPROCK_CRYSTAL, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(50), YOffset.aboveBottom(120))));

    public static final RegistryEntry<PlacedFeature> ORE_ERODED_END_STONE_PLACED = PlacedFeatures.register("eroded_end_stone",
            ModConfiguredFeatures.ERODED_END_STONE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(50), YOffset.aboveBottom(120))));

    public static final RegistryEntry<PlacedFeature> ORE_SILL_PLACED = PlacedFeatures.register("sill",
            ModConfiguredFeatures.SILL, ModOreFeatures.modifiersWithCount(1,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(50), YOffset.aboveBottom(120))));

    public static final RegistryEntry<PlacedFeature> ORE_CONDENSED_VOID = PlacedFeatures.register("condensed_void",
            ModConfiguredFeatures.CONDENSED_VOID, ModOreFeatures.modifiersWithCount(1,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-1), YOffset.aboveBottom(19))));

    public static final RegistryEntry<PlacedFeature> ORE_CRUMBLING_STONE = PlacedFeatures.register("crumbling_stone",
            ModConfiguredFeatures.CRUMBLING_STONE, ModOreFeatures.modifiersWithCount(2,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(2), YOffset.aboveBottom(84))));

    public static final RegistryEntry<PlacedFeature> ORE_CRUMBLING_DEEPSLATE = PlacedFeatures.register("crumbling_deepslate",
            ModConfiguredFeatures.CRUMBLING_DEEPSLATE, ModOreFeatures.modifiersWithCount(2,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-64), YOffset.aboveBottom(0))));

    public static final RegistryEntry<PlacedFeature> ORE_CRUMBLING_NETHERRACK = PlacedFeatures.register("crumbling_netherrack",
            ModConfiguredFeatures.CRUMBLING_NETHERRACK, ModOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(100))));

    public static final RegistryEntry<PlacedFeature> ORE_CRUMBLING_END_STONE = PlacedFeatures.register("crumbling_end_stone",
            ModConfiguredFeatures.CRUMBLING_END_STONE, ModOreFeatures.modifiersWithCount(4,
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(100))));

}
