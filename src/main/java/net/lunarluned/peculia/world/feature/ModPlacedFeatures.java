package net.lunarluned.peculia.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> ORE_MYTHRIL_CRYSTAL_PLACED = PlacementUtils.register("mythril_crystal",
    ModConfiguredFeatures.MYTHRIL_CRYSTAL, ModOreFeatures.modifiersWithCount(1,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-100), VerticalAnchor.aboveBottom(20))));

    public static final Holder<PlacedFeature> ORE_POPROCK_CRYSTAL_PLACED = PlacementUtils.register("poprock_crystal",
    ModConfiguredFeatures.POPROCK_CRYSTAL, ModOreFeatures.modifiersWithCount(4,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(120))));

    public static final Holder<PlacedFeature> ORE_ERODED_END_STONE_PLACED = PlacementUtils.register("eroded_end_stone",
    ModConfiguredFeatures.ERODED_END_STONE, ModOreFeatures.modifiersWithCount(4,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(120))));

    public static final Holder<PlacedFeature> ORE_SILL_PLACED = PlacementUtils.register("sill",
    ModConfiguredFeatures.SILL, ModOreFeatures.modifiersWithCount(1,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(120))));

    public static final Holder<PlacedFeature> ORE_CONDENSED_VOID = PlacementUtils.register("condensed_void",
    ModConfiguredFeatures.CONDENSED_VOID, ModOreFeatures.modifiersWithCount(1,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-1), VerticalAnchor.aboveBottom(19))));

    public static final Holder<PlacedFeature> ORE_CRUMBLING_STONE = PlacementUtils.register("crumbling_stone",
    ModConfiguredFeatures.CRUMBLING_STONE, ModOreFeatures.modifiersWithCount(2,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(2), VerticalAnchor.aboveBottom(84))));

    public static final Holder<PlacedFeature> ORE_CRUMBLING_DEEPSLATE = PlacementUtils.register("crumbling_deepslate",
    ModConfiguredFeatures.CRUMBLING_DEEPSLATE, ModOreFeatures.modifiersWithCount(2,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(0))));

    public static final Holder<PlacedFeature> ORE_CRUMBLING_NETHERRACK = PlacementUtils.register("crumbling_netherrack",
    ModConfiguredFeatures.CRUMBLING_NETHERRACK, ModOreFeatures.modifiersWithCount(3,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100))));

    public static final Holder<PlacedFeature> ORE_CRUMBLING_END_STONE = PlacementUtils.register("crumbling_end_stone",
    ModConfiguredFeatures.CRUMBLING_END_STONE, ModOreFeatures.modifiersWithCount(4,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100))));

    public static final Holder<PlacedFeature> ORE_FLUORITE = PlacementUtils.register("fluorite",
    ModConfiguredFeatures.FLUORITE, ModOreFeatures.modifiersWithCount(2,
    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(40))));

    public static final Holder<PlacedFeature> ORE_SANGUINE_QUARTZ = PlacementUtils.register("sanguine_quartz",
            ModConfiguredFeatures.SANGUINE_QUARTZ, ModOreFeatures.modifiersWithCount(3,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(80), VerticalAnchor.aboveBottom(140))));

}
