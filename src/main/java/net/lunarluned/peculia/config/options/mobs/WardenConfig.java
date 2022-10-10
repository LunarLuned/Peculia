package net.lunarluned.peculia.config.options.mobs;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class WardenConfig {

    @ConfigEntry.Gui.Tooltip
    public boolean cursed_on_hit = true;

    @ConfigEntry.Gui.Tooltip
    public boolean stunned_from_sonic_boom = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.RequiresRestart
    public boolean stat_increase = true;

}
