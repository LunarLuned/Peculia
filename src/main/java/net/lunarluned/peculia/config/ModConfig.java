package net.lunarluned.peculia.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.lunarluned.peculia.config.options.items.ItemsConfig;
import net.lunarluned.peculia.config.options.mobs.VanillaMobsConfig;

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

    // Items

    @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
    public Items items = new Items();

    public static class Items {

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = false)
        @ConfigEntry.Gui.Tooltip
        public ItemsConfig itemsConfig = new ItemsConfig();

    }

}
