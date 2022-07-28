package net.lunarluned.peculia;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.config.Config;
import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.ModGameEvents;
import net.lunarluned.peculia.potion.ModPotions;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.lunarluned.peculia.world.feature.ModConfiguredFeatures;
import net.lunarluned.peculia.world.feature.gen.ModWorldGen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static net.lunarluned.peculia.effect.ModEffects.registerStagnatedEffect;

public class Peculia implements ModInitializer {
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// ඞ
		PeculiaConfig.init();

		String defaultConfig = "{\n" + "  \"defaultconfig_file\": false\n" + "}";

		File configFile = Config.createFile("config/peculia/backupconfig.json", defaultConfig, false);
		JsonObject json = Config.getJsonObject(Config.readFile(configFile));

		PeculiaConfig.generateConfigs(json == null);
		PeculiaConfig.loadConfig();



		ModItems.registerModItems();
		ModGameEvents.registerGameEvents();
		ModGameEvents.init();
		ModSoundEvents.registerSounds();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModWorldGen.generateModWorldGen();

		//disclaimer. i do not know why effects and potions calls for you to register each effect like this. it just does. idk why.
		ModEffects.registerIchorEffect();
		ModEffects.registerElectrocutedEffect();
		ModEffects.registerVoidTouchedEffect();
		ModEffects.registerAnchoredEffect();
		ModEffects.registerIchorResistanceEffect();
		ModEffects.registerPanickedEffect();
		ModEffects.registerStagnatedEffect();

		ModPotions.registerIchorPotion();
		ModPotions.registerextIchorPotion();
		ModPotions.registerIchorResistancePotion();
		ModPotions.registerextIchorResistancePotion();

		LOGGER.info("You have 5 days until the piss droplets hit your minecraft house.");

		LOGGER.info("get trolled");
	}
	public static class ElectrocutionDamageSource extends EntityDamageSource {

		public ElectrocutionDamageSource(Entity source) {
			super("electrocution", source);
			setBypassesArmor();
		}
	}
	public static class IchorDamageSource extends DamageSource {

		public IchorDamageSource(Entity name) {
			super("ichor");
			setBypassesArmor();
			setUnblockable();
		}
	}
	public static class CondensedVoidDamageSource extends DamageSource {

		public CondensedVoidDamageSource(Entity name) {
			super("condensed");
			setUsesMagic();
			setBypassesArmor();
			setBypassesProtection();
		}
	}
	public static class EchoingMirrorDamageSource extends DamageSource {

		public EchoingMirrorDamageSource(Entity name) {
			super("echomirror");
			setUsesMagic();
			setBypassesArmor();
			setBypassesProtection();
		}
	}
}
