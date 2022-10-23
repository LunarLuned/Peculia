package net.lunarluned.peculia.common.registry.misc;

import net.lunarluned.peculia.Peculia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModSignType extends WoodType {
    public ModSignType(String string) {
        super(string);
    }

    public ResourceLocation getTexturePath() {
        return Peculia.id("entity/signs/" + name());
    }
}