package net.lunarluned.peculia.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.lunarluned.peculia.config.options.blocks.BlocksConfig;
import net.lunarluned.peculia.config.options.items.ItemsConfig;
import net.lunarluned.peculia.config.options.mobs.VanillaMobsConfig;
import net.lunarluned.peculia.config.options.visualEffects.VisualEffectsConfig;
import net.minecraft.world.level.block.Block;

// Mod Config


@Config.Gui.Background("peculia:textures/block/mythril_crystal.png")
@Config(name = "peculia")
public class ModConfig implements ConfigData {

    // Mobs

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
    public Mobs mobs = new Mobs();

    public static class Mobs {

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
        @ConfigEntry.Gui.Tooltip
        public VanillaMobsConfig vanillaMobsConfig = new VanillaMobsConfig();

    }

    // Visual Effects

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)

    public VisualEffects visualEffects = new VisualEffects();

    public static class VisualEffects {

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
        @ConfigEntry.Gui.Tooltip
        public VisualEffectsConfig visualEffectsConfig = new VisualEffectsConfig();

    }

    // Items

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
    public Items items = new Items();

    public static class Items {

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
        @ConfigEntry.Gui.Tooltip
        public ItemsConfig itemsConfig = new ItemsConfig();

    }


    // Blocks

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)

    public Blocks blocks = new Blocks();

    public static class Blocks {

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
        @ConfigEntry.Gui.Tooltip
        public BlocksConfig blocksConfig = new BlocksConfig();

    }

}
