package net.lunarluned.peculia.world.feature;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public ModConfiguredFeatures() {
    }

// List of Configured Features:

    public static final List<OreConfiguration.TargetBlockState> ORE_MYTHRIL_CRYSTAL = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.AIR),
    ModBlocks.MYTHRIL_CRYSTAL.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MYTHRIL_CRYSTAL =
    FeatureUtils.register("mythril_crystal", Feature.ORE,
    new OreConfiguration(ORE_MYTHRIL_CRYSTAL, 6));

    public static final List<OreConfiguration.TargetBlockState> ORE_POPROCK_CRYSTAL = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.POPROCK_CRYSTAL.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> POPROCK_CRYSTAL =
    FeatureUtils.register("poprock_crystal", Feature.ORE,
    new OreConfiguration(ORE_POPROCK_CRYSTAL, 12));

    public static final List<OreConfiguration.TargetBlockState> ORE_ERODED_END_STONE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.ERODED_END_STONE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ERODED_END_STONE =
    FeatureUtils.register("eroded_end_stone", Feature.ORE,
    new OreConfiguration(ORE_ERODED_END_STONE, 20));

    public static final List<OreConfiguration.TargetBlockState> ORE_SILL = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.SILL.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILL =
    FeatureUtils.register("sill", Feature.ORE,
    new OreConfiguration(ORE_SILL, 60));

    public static final List<OreConfiguration.TargetBlockState> ORE_FLUORITE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.FLUORITE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> FLUORITE =
    FeatureUtils.register("fluorite", Feature.ORE,
    new OreConfiguration(ORE_FLUORITE, 45));

    public static final List<OreConfiguration.TargetBlockState> ORE_CONDENSED_VOID = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.CONDENSED_VOID.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CONDENSED_VOID =
    FeatureUtils.register("condensed_void", Feature.ORE,
    new OreConfiguration(ORE_CONDENSED_VOID, 60));

    public static final List<OreConfiguration.TargetBlockState> ORE_CRUMBLING_STONE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.STONE),
    ModBlocks.CRUMBLING_STONE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRUMBLING_STONE =
    FeatureUtils.register("crumbling_stone", Feature.ORE,
    new OreConfiguration(ORE_CRUMBLING_STONE, 40));

    public static final List<OreConfiguration.TargetBlockState> ORE_CRUMBLING_DEEPSLATE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE),
    ModBlocks.CRUMBLING_DEEPSLATE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRUMBLING_DEEPSLATE =
    FeatureUtils.register("crumbling_deepslate", Feature.ORE,
    new OreConfiguration(ORE_CRUMBLING_DEEPSLATE, 30));

    public static final List<OreConfiguration.TargetBlockState> ORE_CRUMBLING_NETHERRACK = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK),
    ModBlocks.CRUMBLING_NETHERRACK.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRUMBLING_NETHERRACK =
    FeatureUtils.register("crumbling_netherrack", Feature.ORE,
    new OreConfiguration(ORE_CRUMBLING_NETHERRACK, 45));

    public static final List<OreConfiguration.TargetBlockState> ORE_CRUMBLING_END_STONE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
    ModBlocks.CRUMBLING_END_STONE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRUMBLING_END_STONE =
    FeatureUtils.register("crumbling_endstone", Feature.ORE,
    new OreConfiguration(ORE_CRUMBLING_END_STONE, 30));

    public static final List<OreConfiguration.TargetBlockState> ORE_SANGUINE_QUARTZ_BLOCK = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK),
    ModBlocks.SANGUINE_QUARTZ_BLOCK.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SANGUINE_QUARTZ_BLOCK =
    FeatureUtils.register("sanguine_quartz_block", Feature.ORE,
    new OreConfiguration(ORE_SANGUINE_QUARTZ_BLOCK, 6));

    public static final List<OreConfiguration.TargetBlockState> ORE_CRYPTSTONE = List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE),
    ModBlocks.CRYPTSTONE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRYPTSTONE =
    FeatureUtils.register("cryptstone", Feature.ORE,
    new OreConfiguration(ORE_CRYPTSTONE, 40));


// Registry for Configured Features:

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Configured Features for " + Peculia.MOD_ID);
    }
}