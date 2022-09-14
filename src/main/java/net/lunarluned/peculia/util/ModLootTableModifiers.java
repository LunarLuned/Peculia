package net.lunarluned.peculia.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

// I don't know how any of this works, you're gonna have to figure that out yourself anne sorry! - Sydney
//god i have no clue, for the time being its commented out
/*/

public class ModLootTableModifiers {
        private static final ResourceLocation END_CITY_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/end_city_treasure");
    private static final ResourceLocation SPAWN_BONUS_CHEST_CHEST_ID
            = new ResourceLocation("minecraft", "chests/spawn_bonus_chest");
        private static final ResourceLocation ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/ancient_city_ice_box");
    private static final ResourceLocation ANCIENT_CITY_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/ancient_city");
    private static final ResourceLocation DESERT_PYRAMID_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/desert_pyramid");
    private static final ResourceLocation BASTION_OTHER_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/bastion_other");
    private static final ResourceLocation BASTION_TREASURE_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/bastion_treasure");
    private static final ResourceLocation BASTION_HOGLIN_STABLE_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/bastion_hoglin_stable");
    private static final ResourceLocation STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/stronghold_corridor");
    private static final ResourceLocation STRONGHOLD_CROSSING_STRUCTURE_CHEST_ID
            = new ResourceLocation("minecraft", "chests/stronghold_crossing");

    //bosses
    private static final ResourceLocation WARDEN_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/warden");
    private static final ResourceLocation WITHER_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/wither");
    private static final ResourceLocation ENDER_DRAGON_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/ender_dragon");

    //entities
    private static final ResourceLocation ZOMBIE_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/zombie");
    private static final ResourceLocation DROWNED_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/drowned");
    private static final ResourceLocation HUSK_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/husk");
    private static final ResourceLocation WITHER_SKELETON_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/wither_skeleton");
    private static final ResourceLocation SKELETON_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/skeleton");
    private static final ResourceLocation STRAY_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/stray");
    private static final ResourceLocation WITCH_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/witch");
    private static final ResourceLocation CREEPER_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/creeper");
    private static final ResourceLocation SCULK_SPINE_BLOCK_ID
            = new ResourceLocation("peculia", "blocks/sculk_spine");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            //blocks
            if(SCULK_SPINE_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(setRolls.create(1))
                        .conditionally(LootItemCondition.(0.3f)) // Drops 30% of the time
                        .with(LootPoolEntryContainer.builder(ModItems.SCULK_SAC))
                        .apply(LootItemFunction.builder(NumberProvider.create(12.0f, 38.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //bosses
            if(WITHER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(12.0f, 38.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (source.isBuiltin() && WARDEN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModItems.FALLEN_HERO_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && WARDEN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // Drops 50% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && ENDER_DRAGON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.FALLEN_HERO_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            //entities
            if (source.isBuiltin() && WITHER_SKELETON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f)) // Drops 40% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && ZOMBIE_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && HUSK_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && DROWNED_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && CREEPER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && SKELETON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && STRAY_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            if (source.isBuiltin() && WITCH_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder);
            }
            //structures
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(Items.EMERALD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 7.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f)) // Drops 100% of the time
                        .with(ItemEntry.builder(Items.COPPER_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 10.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.FALLEN_HERO_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f)) // Drops 100% of the time
                        .with(ItemEntry.builder(Items.ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 24.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f)) // Drops 100% of the time
                        .with(ItemEntry.builder(Items.ARROW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 24.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(SPAWN_BONUS_CHEST_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.SCRAMBLED_EGGS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(BASTION_HOGLIN_STABLE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.20f)) // Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.SPORODINE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(BASTION_OTHER_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(10))
                        .conditionally(RandomChanceLootCondition.builder(0.80f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.HOGLIN_TUSK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(BASTION_TREASURE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(10))
                        .conditionally(RandomChanceLootCondition.builder(0.80f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.HOGLIN_TUSK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(BASTION_TREASURE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.SACRIFICIAL_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(END_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.MYTHICAL_BLADE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(END_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.45f)) // Drops 45% of the time
                        .with(ItemEntry.builder(ModItems.DISC_FRAGMENT_LULLA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.40f)) // Drops 40% of the time
                        .with(ItemEntry.builder(ModItems.SCULK_SAC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(23.0f, 50.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.30f)) // Drops 10% of the time
                        .with(ItemEntry.builder(ModItems.FULL_SCULK_SAC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 10.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(DESERT_PYRAMID_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.20f)) // Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.COPPER_CLEAVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.CHARGED_COPPER_CLEAVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.50f)) // Drops 50% of the time
                        .with(ItemEntry.builder(ModBlocks.SCULK_SPINE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 12.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(ModItems.FALLEN_HERO_DAGGER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());

            }
        });
        }
}
/**/
