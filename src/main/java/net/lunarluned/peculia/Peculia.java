package net.lunarluned.peculia;

import net.fabricmc.api.ModInitializer;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.effect.EchoEffect;
import net.lunarluned.peculia.effect.IchorEffect;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.world.feature.ModConfiguredFeatures;
import net.lunarluned.peculia.world.feature.gen.ModWorldGen;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Peculia implements ModInitializer {
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModWorldGen.generateModWorldGen();
		ModEffects.registerEffects();
		ModEffects.registerIchorEffect();

		LOGGER.info("You have 5 days until the piss droplets hit your minecraft house.");
	}
}
