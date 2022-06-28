package net.lunarluned.peculia;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.config.Config;
import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.potion.ModPotions;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.lunarluned.peculia.world.feature.ModConfiguredFeatures;
import net.lunarluned.peculia.world.feature.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Peculia implements ModInitializer {
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// ඞ
		PeculiaConfig.init();

		String defaultConfig = "{\n" + "  \"regen_enchantment_config_file\": false\n" + "}";

		File configFile = Config.createFile("config/fabricenchantments/backupconfig.json", defaultConfig, false);
		JsonObject json = Config.getJsonObject(Config.readFile(configFile));

		PeculiaConfig.generateConfigs(json == null);
		PeculiaConfig.loadConfig();



		ModItems.registerModItems();
		ModSoundEvents.registerSounds();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModWorldGen.generateModWorldGen();

		//disclaimer. i do not know why effects and potions calls for you to register each effect like this. it just does. idk why.
		ModEffects.registerIchorEffect();
		ModEffects.registerElectrocutedEffect();

		ModPotions.registerIchorPotion();
		ModPotions.registerextIchorPotion();


		LOGGER.info("You have 5 days until the piss droplets hit your minecraft house.");
	}
}
