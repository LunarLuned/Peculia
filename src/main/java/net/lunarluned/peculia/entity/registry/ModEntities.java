package net.lunarluned.peculia.entity.registry;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.entity.projectiles.PeculiarSliceEntity;
import net.lunarluned.peculia.misc.CoreRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final CoreRegistry<EntityType<?>> ENTITIES = CoreRegistry.create(Registry.ENTITY_TYPE_REGISTRY, Peculia.MOD_ID);

    public static final EntityType<PeculiarSliceEntity> PECULIAR_SLICE = register("peculiar_slice", EntityType.Builder.of(PeculiarSliceEntity::new, MobCategory.MISC).sized(0.6F, 0.6F));

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return ENTITIES.register(id, type.build(id));
    }


    public static void registerModEntities() {
        System.out.println("Registering Entities for " + Peculia.MOD_ID);
    }
}
