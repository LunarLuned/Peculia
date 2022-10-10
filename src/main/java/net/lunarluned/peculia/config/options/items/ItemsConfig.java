package net.lunarluned.peculia.config.options.items;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ItemsConfig {
    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public ItemChances itemChances = new ItemChances();

    @ConfigEntry.Gui.CollapsibleObject()
    @ConfigEntry.Gui.Tooltip
    public PotionItemsConfig potionItemsConfig = new PotionItemsConfig();
}
