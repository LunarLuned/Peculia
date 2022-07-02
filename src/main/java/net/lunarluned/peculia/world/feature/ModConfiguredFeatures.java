package net.lunarluned.peculia.world.feature;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public ModConfiguredFeatures() {
    }

// List of Configured Features:

    public static final List<OreFeatureConfig.Target> ORE_MYTHRIL_CRYSTAL = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.AIR),
                    ModBlocks.MYTHRIL_CRYSTAL.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MYTHRIL_CRYSTAL =
            ConfiguredFeatures.register("mythril_crystal", Feature.ORE,
                    new OreFeatureConfig(ORE_MYTHRIL_CRYSTAL, 6));

    public static final List<OreFeatureConfig.Target> ORE_POPROCK_CRYSTAL = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.POPROCK_CRYSTAL.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> POPROCK_CRYSTAL =
            ConfiguredFeatures.register("poprock_crystal", Feature.ORE,
                    new OreFeatureConfig(ORE_POPROCK_CRYSTAL, 12));

    public static final List<OreFeatureConfig.Target> ORE_ERODED_END_STONE = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.ERODED_END_STONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ERODED_END_STONE =
            ConfiguredFeatures.register("eroded_end_stone", Feature.ORE,
                    new OreFeatureConfig(ORE_ERODED_END_STONE, 20));

    public static final List<OreFeatureConfig.Target> ORE_SILL = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.SILL.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SILL =
            ConfiguredFeatures.register("sill", Feature.ORE,
                    new OreFeatureConfig(ORE_SILL, 60));

    public static final List<OreFeatureConfig.Target> ORE_CONDENSED_VOID = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.CONDENSED_VOID.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CONDENSED_VOID =
            ConfiguredFeatures.register("condensed_void", Feature.ORE,
                    new OreFeatureConfig(ORE_CONDENSED_VOID, 60));


// Registry for Configured Features:

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Configured Features for " + Peculia.MOD_ID);
    }
}