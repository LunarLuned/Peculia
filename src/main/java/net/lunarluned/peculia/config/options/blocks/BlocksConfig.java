package net.lunarluned.peculia.config.options.blocks;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.lunarluned.peculia.config.options.items.ItemChances;


public class BlocksConfig {
        @ConfigEntry.Gui.CollapsibleObject()
        @ConfigEntry.Gui.Tooltip
        public BlockChances blockChances = new BlockChances();


    }
