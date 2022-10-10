package net.lunarluned.peculia.config.options.mobs;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class VanillaMobsConfig {
    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public GhastConfig ghastConfig = new GhastConfig();

    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public WitherConfig witherConfig = new WitherConfig();

    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public WardenConfig wardenConfig = new WardenConfig();
}
