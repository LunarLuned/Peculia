package net.lunarluned.peculia.config.options.visualEffects;

import me.shedaniel.autoconfig.annotation.ConfigEntry;


public class VisualEffectsConfig {
    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public ParticlesConfig particlesConfig = new ParticlesConfig();
}
