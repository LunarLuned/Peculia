package net.lunarluned.peculia.common.registry.entity.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode.CoalGeodeEntity;
import net.lunarluned.peculia.common.registry.entity.living_entities.ghost.GhostEntity;
import net.lunarluned.peculia.common.registry.entity.projectiles.SwordProjectionEntity;
import net.lunarluned.peculia.misc.CoreRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final CoreRegistry<EntityType<?>> ENTITIES = CoreRegistry.create(Registry.ENTITY_TYPE_REGISTRY, Peculia.MOD_ID);

    public static final EntityType<SwordProjectionEntity> SWORD_PROJECTION = register("sword_projection", EntityType.Builder.of(SwordProjectionEntity::new, MobCategory.MISC).sized(1, 1).clientTrackingRange(10));
    public static final EntityType<CoalGeodeEntity> COAL_GEODE = register("coal_geode", EntityType.Builder.of(CoalGeodeEntity::new, MobCategory.CREATURE).sized(0.7f, 0.85f).clientTrackingRange(10));
    public static final EntityType<GhostEntity> GHOST = register("ghost", EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER).sized(0.8f, 1.9f).clientTrackingRange(10));

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return ENTITIES.register(id, type.build(id));
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(COAL_GEODE, CoalGeodeEntity.createCoalGeodeAttributes());
        FabricDefaultAttributeRegistry.register(GHOST, GhostEntity.createGhostAttributes());
    }

    public static void registerModEntities() {
        System.out.println("Registering Entities for " + Peculia.MOD_ID);
    }
}
