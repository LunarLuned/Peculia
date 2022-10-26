package net.lunarluned.peculia;

import com.google.gson.JsonObject;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.config.ModConfig;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.compat.CombatantItems;
import net.lunarluned.peculia.item.compat.OdysseyItems;
import net.lunarluned.peculia.misc.ModGameEvents;
import net.lunarluned.peculia.misc.ModInstruments;
import net.lunarluned.peculia.misc.ModParticles;
import net.lunarluned.peculia.potion.ModPotions;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.lunarluned.peculia.util.ModLootTableModifiers;
import net.lunarluned.peculia.world.feature.ModConfiguredFeatures;
import net.lunarluned.peculia.world.feature.gen.ModWorldGen;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.level.biome.Biomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

public class Peculia implements ModInitializer {
	private static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

	@Override
	public void onInitialize() {

		// ඞ

		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY), MobCategory.MONSTER, ModEntities.GHOST, 1, 0, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY), MobCategory.CREATURE, ModEntities.WISP, 1, 0, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DRIPSTONE_CAVES), MobCategory.CREATURE, ModEntities.COAL_GEODE, 2, 1, 1);

		// Strippable Blocks

		StrippableBlockRegistry.register(ModBlocks.GRIM_WOOD, ModBlocks.STRIPPED_GRIM_WOOD);
		StrippableBlockRegistry.register(ModBlocks.GRIM_WOOD_LOG, ModBlocks.STRIPPED_GRIM_WOOD_LOG);

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
		ModEffects.registerBanishingEffect();
		ModEffects.registerPorousEffect();
		ModEffects.registerElectrocutedEffect();
		ModEffects.registerVoidTouchedEffect();
		ModEffects.registerAnchoredEffect();
		ModEffects.registerCursedEffect();
		ModEffects.registerIchorResistanceEffect();
		ModEffects.registerDeterminedStatusEffect();
		ModEffects.registerStagnatedEffect();
		ModEffects.registerEchoingEffect();
		ModEffects.registerStunnedEffect();

		if (Peculia.getConfig().items.itemsConfig.potionItemsConfig.allow_ichor_potions) {
			ModPotions.registerIchorPotion();
			ModPotions.registerextIchorPotion();
		}
		if (Peculia.getConfig().items.itemsConfig.potionItemsConfig.allow_darkness_potions) {
			ModPotions.registerDarknessPotion();
			ModPotions.registerextDarknessPotion();
		}
		    ModPotions.registerBanishedPotion();
			ModPotions.registerIchorResistancePotion();
			ModPotions.registerextIchorResistancePotion();

			ModLootTableModifiers.modifyLootTables();


		if (FabricLoader.getInstance().isModLoaded("combatant")) {
			CombatantItems.registerCombatantCompatItems();
		}
		if (FabricLoader.getInstance().isModLoaded("odyssey")) {
			OdysseyItems.registerOdysseyCompatItems();
		}

		// Tusk Horns

		Registry.register(Registry.INSTRUMENT, ModInstruments.STAMPEDE_HOG_HORN, new Instrument(ModSoundEvents.ITEM_HOG_HORN_STAMPEDE, 140, 256.0F));
		Registry.register(Registry.INSTRUMENT, ModInstruments.PULSE_HOG_HORN, new Instrument(ModSoundEvents.ITEM_HOG_HORN_PULSE, 140, 256.0F));
		Registry.register(Registry.INSTRUMENT, ModInstruments.CRY_HOG_HORN, new Instrument(ModSoundEvents.ITEM_HOG_HORN_CRY, 140, 256.0F));

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
	public static class JawDamageSource extends DamageSource {

		public JawDamageSource() {
			super("jaw");
		}
	}
	public static class SiphoningDamageSource extends DamageSource {

		public SiphoningDamageSource() {
			super("siphoning");
			bypassArmor();
			bypassEnchantments();
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
	// Mod Config

	public static ModConfig getConfig () {
		return CONFIG;
	}
}
