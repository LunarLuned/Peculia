package net.lunarluned.peculia.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lunarluned.peculia.entity.ModEntities;
import net.lunarluned.peculia.entity.custom.CoalGeodeEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }



    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.COALGEODE, CoalGeodeEntity.setAttributes());
    }
}