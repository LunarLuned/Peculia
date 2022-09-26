package net.lunarluned.peculia;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.config.Config;
import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.compat.CombatantItems;
import net.lunarluned.peculia.item.compat.OdysseyItems;
import net.lunarluned.peculia.misc.ModGameEvents;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.potion.ModPotions;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.lunarluned.peculia.util.ModLootTableModifiers;
import net.lunarluned.peculia.world.feature.ModConfiguredFeatures;
import net.lunarluned.peculia.world.feature.gen.ModWorldGen;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

public class Peculia implements ModInitializer {
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		// To Fix:

		                                        // - Greater Tome of Healing - fixed!
		                                        // - Both Updraft Tomes - fixed!
		                                        // - Both Tomes of Fortifying - fixed!
		                                        // - Ichor Stichor - fixed!
		// - Sculk Sac and Full Sculk Sac
		                                        // - Electrocuted Effect - fixed!
		                                        // - Loot Table Modifiers - fixed

		// ඞ
		PeculiaConfig.init();
		String defaultConfig = """
				{
				  "defaultconfig_file": false
				}""";
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

		ModParticles.PARTICLES.register();
		ModEntities.registerModEntities();
		ModEntities.registerAttributes();

		//disclaimer. i do not know why effects and potions calls for you to register each effect like this. it just does. idk why.

		ModEffects.registerIchorEffect();
		ModEffects.registerElectrocutedEffect();
		ModEffects.registerVoidTouchedEffect();
		ModEffects.registerAnchoredEffect();
		ModEffects.registerCursedEffect();
		ModEffects.registerIchorResistanceEffect();
		ModEffects.registerDeterminedStatusEffect();
		ModEffects.registerStagnatedEffect();
		ModEffects.registerEchoingEffect();
		ModEffects.registerStunnedEffect();

		ModPotions.registerIchorPotion();
		ModPotions.registerextIchorPotion();
		ModPotions.registerDarknessPotion();
		ModPotions.registerextDarknessPotion();
		ModPotions.registerIchorResistancePotion();
		ModPotions.registerextIchorResistancePotion();
		ModLootTableModifiers.modifyLootTables();


		if (FabricLoader.getInstance().isModLoaded("combatant")) {
			CombatantItems.registerCombatantCompatItems();
		}
		if (FabricLoader.getInstance().isModLoaded("odyssey")) {
			OdysseyItems.registerOdysseyCompatItems();
		}

		// Furnace Fuel

		FuelRegistry.INSTANCE.add(ModItems.SOUL, 1000);

		LOGGER.info("You have 5 days until the piss droplets hit your minecraft house.");
		LOGGER.info("ඞ");
	}

	// Damage Sources

	public static class ElectrocutionDamageSource extends EntityDamageSource {

		public ElectrocutionDamageSource(Entity source) {
			super("electrocution", source);
			bypassArmor();
		}
	}
	public static class IchorDamageSource extends DamageSource {

		public IchorDamageSource() {
			super("ichor");
			bypassArmor();
		}
	}
	public static class EchoingDamageSource extends DamageSource {

		public EchoingDamageSource() {
			super("echoing");
			setMagic();
		}
	}
	public static class CondensedVoidDamageSource extends DamageSource {

		public CondensedVoidDamageSource() {
			super("condensed");
			setMagic();
			bypassArmor();
			bypassEnchantments();
		}
	}
	public static class EchoingMirrorDamageSource extends DamageSource {

		public EchoingMirrorDamageSource() {
			super("echomirror");
			setMagic();
			bypassArmor();
			bypassEnchantments();
		}
	}
	public static class AnchoredDamageSource extends DamageSource {

		public AnchoredDamageSource() {
			super("anchored");
			setMagic();
			bypassArmor();
			bypassEnchantments();
		}
	}
}
