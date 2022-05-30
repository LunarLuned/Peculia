package net.lunarluned.peculia.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.entity.custom.CoalGeodeEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {


    public static final EntityType<CoalGeodeEntity> COALGEODE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Peculia.MOD_ID, "coalgeode"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CoalGeodeEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());

}
