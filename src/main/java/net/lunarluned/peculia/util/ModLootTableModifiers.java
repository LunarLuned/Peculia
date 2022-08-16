package net.lunarluned.peculia.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
        private static final Identifier END_CITY_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier SPAWN_BONUS_CHEST_CHEST_ID
            = new Identifier("minecraft", "chests/spawn_bonus_chest");
        private static final Identifier ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/ancient_city_ice_box");
    private static final Identifier ANCIENT_CITY_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier DESERT_PYRAMID_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier BASTION_OTHER_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_other");
    private static final Identifier BASTION_TREASURE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier BASTION_HOGLIN_STABLE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_hoglin_stable");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
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
        });
        }
}

