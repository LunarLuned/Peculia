package net.lunarluned.peculia.config.options.mobs;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class WitherConfig {

    @ConfigEntry.Gui.Tooltip
    public boolean stagnated_on_hit = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean stat_increase = true;

}
