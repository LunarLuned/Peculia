package net.lunarluned.peculia.config.options.items;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class PotionItemsConfig {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean allow_darkness_potions = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean allow_ichor_potions = true;
}
