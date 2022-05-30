package net.lunarluned.peculia.world.feature.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lunarluned.peculia.world.feature.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {

    public static void generateOres() {


// Generation Mythril Ore:

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ORE_MYTHRIL_CRYSTAL_PLACED.getKey().get());

    }
}
