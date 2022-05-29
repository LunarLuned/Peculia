package net.lunarluned.peculia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.enchantment.ModEnchantments;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Peculia implements ModInitializer {
	public static final String MOD_ID = "peculia";
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantMents();


		LOGGER.info("You have 5 days until the piss droplets hit your minecraft house.");
	}
}
