package net.lunarluned.peculia.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.PeculiaTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetInstrumentFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;




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
    private static final ResourceLocation CRYPT_TOMB_STRUCTURE_CHEST_ID
            = new ResourceLocation("peculia", "chests/crypt_tomb");

    //bosses
    private static final ResourceLocation WARDEN_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/warden");
    private static final ResourceLocation WITHER_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/wither");
    private static final ResourceLocation ENDER_DRAGON_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/ender_dragon");

    //block
    private static final ResourceLocation GRAVESTONE_BLOCK_ID
            = new ResourceLocation("peculia", "blocks/gravestone");

    //entities
    private static final ResourceLocation ZOMBIE_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/zombie");
    private static final ResourceLocation SPIDER_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/spider");
    private static final ResourceLocation CAVE_SPIDER_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/cave_spider");
    private static final ResourceLocation ENDERMAN_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/enderman");
    private static final ResourceLocation ENDERMITE_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/endermite");
    private static final ResourceLocation ZOMBIFIED_PIGLIN_ENTITY_ID
            = new ResourceLocation("minecraft", "entities/zombified_piglin");
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
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, table, setter) -> {
            //blocks
            if(SCULK_SPINE_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(0, 3)); // at the least you'll get 0, at most 3
                builder.add(LootItem.lootTableItem(ModItems.SCULK_SAC));
                table.withPool(builder);
            }
            if(GRAVESTONE_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.85f)); //85% chance
                builder.setRolls(UniformGenerator.between(1, 3)); // at the least you'll get 1, at most 3
                builder.add(LootItem.lootTableItem(Items.ROTTEN_FLESH));
                table.withPool(builder);
            }
            if(GRAVESTONE_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.70f)); //20% chance
                builder.setRolls(UniformGenerator.between(1, 6)); // at the least you'll get 1, at most 6
                builder.add(LootItem.lootTableItem(Items.BONE));
                table.withPool(builder);
            }
            if(GRAVESTONE_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.50f)); //20% chance
                builder.setRolls(UniformGenerator.between(1, 2)); // at the least you'll get 1, at most 6
                builder.add(LootItem.lootTableItem(Items.DRIED_KELP));
                table.withPool(builder);
            }
            //bosses
            if(WITHER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(1f)); //100% chance
                builder.setRolls(UniformGenerator.between(12, 42)); // at the least you'll get 12, at most 42
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);

            }
            if(WARDEN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  you'll get 1
                builder.add(LootItem.lootTableItem(ModItems.FALLEN_HERO_DAGGER));
                table.withPool(builder);

            }
            if(WARDEN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.9f)); //90% chance
                builder.setRolls(UniformGenerator.between(7, 26)); //  at the least you'll get 7, at most 26
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);

            }
            if(ENDER_DRAGON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(1f)); //90% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  you'll get 1
                builder.add(LootItem.lootTableItem(ModItems.FALLEN_HERO_SWORD));
                table.withPool(builder);

            }
            //entities
            if(WITHER_SKELETON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.6f)); //90% chance
                builder.setRolls(UniformGenerator.between(4, 8)); //  you'll get 1
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);

            }
            if(ZOMBIE_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(HUSK_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(DROWNED_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(CREEPER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(SKELETON_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(SPIDER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(CAVE_SPIDER_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(ENDERMAN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 7)); //  1 to 7
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(ENDERMITE_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(3, 10)); //  3 to 10
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(ZOMBIFIED_PIGLIN_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(STRAY_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 4)); //  1 to 4
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            if(WITCH_ENTITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(3, 6)); //  3 to 6
                builder.add(LootItem.lootTableItem(ModItems.SOUL));
                table.withPool(builder);
            }
            //structures
            if(CRYPT_TOMB_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1
                builder.add(LootItem.lootTableItem(ModItems.LESSER_TOME_OF_HARVESTING));
                table.withPool(builder);
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(1f)); //100% chance
                builder.setRolls(UniformGenerator.between(3, 7)); //  3 to 7
                builder.add(LootItem.lootTableItem(Items.EMERALD));
                table.withPool(builder);
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.8f)); //80% chance
                builder.setRolls(UniformGenerator.between(4, 12)); //  4 to 12
                builder.add(LootItem.lootTableItem(Items.COPPER_INGOT));
                table.withPool(builder);
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.05f)); //5% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  4 to 12
                builder.add(LootItem.lootTableItem(ModItems.FALLEN_HERO_SWORD));
                table.withPool(builder);
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.9f)); //90% chance
                builder.setRolls(UniformGenerator.between(4, 24)); //  4 to 12
                builder.add(LootItem.lootTableItem(Items.ARROW));
                table.withPool(builder);
            }
            if(STRONGHOLD_CORRIDOR_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.9f)); //90% chance
                builder.setRolls(UniformGenerator.between(4, 24)); //  4 to 12
                builder.add(LootItem.lootTableItem(Items.ARROW));
                table.withPool(builder);
            }
            if(SPAWN_BONUS_CHEST_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(1f)); //100% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1
                builder.add(LootItem.lootTableItem(ModItems.SCRAMBLED_EGGS));
                table.withPool(builder);
            }
            if(BASTION_HOGLIN_STABLE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.2f)); //20% chance
                builder.setRolls(UniformGenerator.between(1, 2)); //  1 to 2
                builder.add(LootItem.lootTableItem(ModItems.SPORODINE));
                table.withPool(builder);
            }
            if(BASTION_OTHER_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.6f)); //60% chance
                builder.setRolls(UniformGenerator.between(1, 5)); //  1 to 5
                builder.add(LootItem.lootTableItem(ModItems.HOGLIN_TUSK));
                table.withPool(builder);
            }
            if(BASTION_OTHER_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.4f)); //40% chance
                builder.setRolls(UniformGenerator.between(1, 1));
                builder.add(LootItem.lootTableItem(ModItems.TUSK_HORN).apply(SetInstrumentFunction.setInstrumentOptions(PeculiaTags.TUSK_HORNS)));
                table.withPool(builder);
            }
            if(BASTION_TREASURE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.2f)); //20% chance
                builder.setRolls(UniformGenerator.between(3, 5)); //  3 to 5
                builder.add(LootItem.lootTableItem(ModItems.HOGLIN_TUSK));
                table.withPool(builder);
            }
            if(BASTION_TREASURE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.05f)); //5% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1
                builder.add(LootItem.lootTableItem(ModItems.SACRIFICIAL_DAGGER));
                table.withPool(builder);
            }
            if(END_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.1f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1
                builder.add(LootItem.lootTableItem(ModItems.MYTHICAL_BLADE));
                table.withPool(builder);
            }
            if(END_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.45f)); //10% chance
                builder.setRolls(UniformGenerator.between(1, 3)); //  1
                builder.add(LootItem.lootTableItem(ModItems.DISC_FRAGMENT_LULLA));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.45f)); //45% chance
                builder.setRolls(UniformGenerator.between(23, 50)); //  23 to 50
                builder.add(LootItem.lootTableItem(ModItems.SCULK_SAC));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.30f)); //30% chance
                builder.setRolls(UniformGenerator.between(23, 50)); //  23 to 50
                builder.add(LootItem.lootTableItem(ModItems.SCULK_SAC));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_ICE_BOX_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.30f)); //30% chance
                builder.setRolls(UniformGenerator.between(2, 10)); //  2 to 10
                builder.add(LootItem.lootTableItem(ModItems.FULL_SCULK_SAC));
                table.withPool(builder);
            }
            if(DESERT_PYRAMID_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.20f)); //30% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1 to 1
                builder.add(LootItem.lootTableItem(ModItems.COPPER_CLEAVER));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.05f)); //5% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1 to 1
                builder.add(LootItem.lootTableItem(ModItems.JAILORS_SCYTHE));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.05f)); //5% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1 to 1
                builder.add(LootItem.lootTableItem(ModItems.GILDED_COPPER_CLEAVER));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.50f)); //50% chance
                builder.setRolls(UniformGenerator.between(2, 12)); //  1 to 1
                builder.add(LootItem.lootTableItem(ModBlocks.SCULK_SPINE));
                table.withPool(builder);
            }
            if(ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1));
                LootPool.Builder builder = LootPool.lootPool();
                builder.when(LootItemRandomChanceCondition.randomChance(0.05f)); //50% chance
                builder.setRolls(UniformGenerator.between(1, 1)); //  1 to 1
                builder.add(LootItem.lootTableItem(ModItems.FALLEN_HERO_DAGGER));
                table.withPool(builder);
            }
        });
    }
}