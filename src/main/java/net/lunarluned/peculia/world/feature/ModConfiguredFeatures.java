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
            ConfiguredFeatures.register("mythril_crystal", Feature.SCATTERED_ORE,
                    new OreFeatureConfig(ORE_MYTHRIL_CRYSTAL, 2));


// Registry for Configured Features:

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Configured Features for " + Peculia.MOD_ID);
    }
}