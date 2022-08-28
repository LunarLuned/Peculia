package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.fluid.ModFluids;
import net.lunarluned.peculia.item.custom.*;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // misc / not in any dimension
    public static final Item FALLEN_HERO_DAGGER = registerItem("fallen_hero_dagger",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item FALLEN_HERO_SWORD = registerItem("fallen_hero_sword",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).rarity(Rarity.UNCOMMON)));
  //  public static final Item PECULIAR_DAGGER = registerItem("peculiar_dagger",
   //         new PeculiarDaggerItem(ModToolMaterials.PECULIAR,3, -2.0f,new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).rarity(Rarity.EPIC)));

    //end

    public static final Item MYTHRIL_SHARD = registerItem("mythril_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_FRAGMENT = registerItem("mythril_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item EMPTY_MIRROR = registerItem("empty_mirror",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1).rarity(Rarity.COMMON)));
    public static final Item ECHOING_MIRROR = registerItem("echoing_mirror",
            new EchoingMirrorItem(new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1).rarity(Rarity.RARE).maxDamage(16)));
    public static final Item MYTHRIL_CLAYMORE = registerItem("mythril_claymore",
            new ModSwordItem(ModToolMaterials.MYTHRIL,5, -2.7f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_SCYTHE = registerItem("mythril_scythe",
            new ModHoeItem(ModToolMaterials.MYTHRIL, 2, -2.5f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_HALBERD = registerItem("mythril_halberd",
            new ModAxeItem(ModToolMaterials.MYTHRIL,8, -3.1f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_HAMMER = registerItem("mythril_hammer",
            new ModPickaxeItem(ModToolMaterials.MYTHRIL, 9, -3.4f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_SPEAREL = registerItem("mythril_spearel",
            new ModShovelItem(ModToolMaterials.MYTHRIL, 1, -2.4f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_GAUNTLET = registerItem("mythril_gauntlet",
            new ModGauntletItem(ModToolMaterials.MYTHRIL, 3, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item POPROCKS = registerItem("poprocks",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA).food(ModFoodComponents.POPROCKS)));
    public static final Item ROCK_CANDY = registerItem("rock_candy",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA).food(ModFoodComponents.ROCK_CANDY)));
    public static final Item BOTTLE_OF_CONDENSED_VOID = registerItem("bottle_of_condensed_void",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHICAL_BLADE = registerItem("mythical_blade",
            new ModDaggerItem(ModToolMaterials.SHARD,2, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item GILDED_MYTHICAL_BLADE = registerItem("gilded_mythical_blade",
            new ModDaggerItem(ModToolMaterials.SHARD,3, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item VOID_TOUCHED_MYTHICAL_BLADE = registerItem("void_touched_mythical_blade",
            new VoidTouchedItem(ModToolMaterials.SHARD,0, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item VOID_TOUCHED_GILDED_MYTHICAL_BLADE = registerItem("void_touched_gilded_mythical_blade",
            new VoidTouchedItem(ModToolMaterials.SHARD,1, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));


    public static final Item SILLTAR_BUCKET = registerItem("silltar_bucket",
            new BucketItem(ModFluids.SILLTAR_STILL, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));

    public static final Item MUSIC_DISC_LULLA = registerItem("music_disc_lulla",
            new ModMusicDiscItem(7, ModSoundEvents.MUSIC_DISC_LULLA,
                    new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).group(ModItemGroup.PECULIA), 194));
    public static final Item DISC_FRAGMENT_LULLA = registerItem("disc_fragment_lulla",
            new DiscFragmentItem(new FabricItemSettings().group(ModItemGroup.PECULIA)));

    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_LEGGINGS = registerItem("mythril_leggings",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots",
            new ArmorItem(ModArmorMaterials.MYTHRIL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.PECULIA)));

    //nether
    public static final Item HOGLIN_TUSK = registerItem("hoglin_tusk",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));
    public static final Item CRIMSON_STEW = registerItem("crimson_stew",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER).food(ModFoodComponents.CRIMSON_STEW).maxCount(1)));
    public static final Item WARPED_STEW = registerItem("warped_stew",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER).food(ModFoodComponents.WARPED_STEW).maxCount(1)));
    public static final Item FUNGAL_STEW = registerItem("fungal_stew",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER).food(ModFoodComponents.FUNGAL_STEW).maxCount(1)));
    public static final Item MUSHROOM_STEW_TUSK = registerItem("mushroom_stew_tusk",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER).food(ModFoodComponents.MUSHROOM_STEW_TUSK).maxCount(1)));
    public static final Item EGG_TUSK = registerItem("egg_tusk",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));
    public static final Item SCRAMBLED_EGGS_TUSK = registerItem("scrambled_eggs_tusk",
            new HoglinTuskItem(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER).food(ModFoodComponents.SCRAMBLED_EGGS_TUSK).maxCount(1)));

    public static final Item NETHERITE_GAUNTLET = registerItem("netherite_gauntlet",
            new ModGauntletItem(ToolMaterials.NETHERITE, 3, -2.209f, new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));
    public static final Item SACRIFICIAL_DAGGER = registerItem("sacrificial_dagger",
            new ModDaggerItem(ModToolMaterials.SCRAP,1, -2.2f, new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER).maxCount(1)));
    public static final Item GILDED_SACRIFICIAL_DAGGER = registerItem("gilded_sacrificial_dagger",
            new ModDaggerItem(ModToolMaterials.SCRAP,2, -2.0f, new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER).maxCount(1)));
    public static final Item DIPPED_SACRIFICIAL_DAGGER = registerItem("dipped_sacrificial_dagger",
             new ModDippedItem(ModToolMaterials.SCRAP,-1, -2.2f, new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER).maxCount(1)));
    public static final Item DIPPED_GILDED_SACRIFICIAL_DAGGER = registerItem("dipped_gilded_sacrificial_dagger",
            new ModDippedItem(ModToolMaterials.SCRAP,0, -2.0f, new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER).maxCount(1)));
    public static final Item ICHOR = registerItem("ichor",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER)));
    public static final Item SPORODINE = registerItem("sporodine",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER)));


    //overworld
    public static final Item DIAMOND_GAUNTLET = registerItem("diamond_gauntlet",
            new ModGauntletItem(ToolMaterials.DIAMOND, 2, -2.2f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD)));
    public static final Item IRON_GAUNTLET = registerItem("iron_gauntlet",
            new ModGauntletItem(ToolMaterials.IRON, 2, -2.3f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD)));
    public static final Item GOLDEN_GAUNTLET = registerItem("golden_gauntlet",
            new ModGauntletItem(ToolMaterials.GOLD, 3, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD)));
    public static final Item COPPER_CLEAVER = registerItem("copper_cleaver",
            new ModDaggerItem(ModToolMaterials.COPPER,1, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));
    public static final Item GILDED_COPPER_CLEAVER = registerItem("gilded_copper_cleaver",
            new ModDaggerItem(ModToolMaterials.COPPER,2, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));
    public static final Item CHARGED_COPPER_CLEAVER = registerItem("charged_copper_cleaver",
            new ElectrocutedItem(ModToolMaterials.COPPER,0, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));
    public static final Item CHARGED_GILDED_COPPER_CLEAVER = registerItem("charged_gilded_copper_cleaver",
            new ElectrocutedItem(ModToolMaterials.COPPER,1, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item SOUL = registerItem("soul",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).rarity(Rarity.UNCOMMON)));

    public static final Item SCULK_SAC = registerItem("sculk_sac",
            new SculkSacItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).rarity(Rarity.UNCOMMON)));
    public static final Item FULL_SCULK_SAC = registerItem("full_sculk_sac",
            new FullSculkSacItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).rarity(Rarity.UNCOMMON)));

    public static final Item SWEET_ROLL = registerItem("sweet_roll",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.SWEET_ROLL)));
    public static final Item HARD_BOILED_EGG = registerItem("hard_boiled_egg",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.HARD_BOILED_EGG).maxCount(16)));
    public static final Item EGG_BOWL = registerItem("egg_bowl",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(16)));
    public static final Item SCRAMBLED_EGGS = registerItem("scrambled_eggs",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.SCRAMBLED_EGGS).maxCount(16)));
    public static final Item RAW_BACON_STRIP = registerItem("raw_bacon_strip",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.RAW_BACON).maxCount(64)));
    public static final Item COOKED_BACON_STRIP = registerItem("cooked_bacon_strip",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.COOKED_BACON).maxCount(64)));
    public static final Item RAW_BEEF_PATTY = registerItem("raw_beef_patty",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.BEEF_PATTY).maxCount(64)));
    public static final Item COOKED_BEEF_PATTY = registerItem("cooked_beef_patty",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.COOKED_BEEF_PATTY).maxCount(64)));
    public static final Item BURGER = registerItem("burger",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.BURGER).maxCount(64)));
    public static final Item BACON_BURGER = registerItem("bacon_burger",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.BACON_BURGER).maxCount(64)));

    public static final Item SWEET_BERRY_JAM = registerItem("sweet_berry_jam",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.SWEET_BERRY_JAM).maxCount(1)));
    public static final Item APPLE_JAM = registerItem("apple_jam",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.APPLE_JAM).maxCount(1)));
    public static final Item CACTUS_JAM = registerItem("cactus_jam",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.CACTUS_JAM).maxCount(1)));
    public static final Item COCOA_SPREAD = registerItem("cocoa_spread",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.COCOA_SPREAD).maxCount(1)));
    public static final Item MUSHROOM_PUREE = registerItem("mushroom_puree",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.MUSHROOM_PUREE).maxCount(1)));
    public static final Item PORK_PATE = registerItem("pork_pate",
            new JamBottleItem(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.PORK_PATE).maxCount(1)));

    public static final Item TOASTED_BREAD = registerItem("toasted_bread",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.TOASTED_BREAD).maxCount(64)));
    public static final Item TOAST = registerItem("toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.TOAST).maxCount(64)));
    public static final Item BERRY_SPREAD_TOAST = registerItem("berry_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.BERRY_SPREAD_TOAST).maxCount(64)));
    public static final Item APPLE_SPREAD_TOAST = registerItem("apple_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.APPLE_SPREAD_TOAST).maxCount(64)));
    public static final Item CACTUS_SPREAD_TOAST = registerItem("cactus_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.CACTUS_SPREAD_TOAST).maxCount(64)));
    public static final Item COCOA_SPREAD_TOAST = registerItem("cocoa_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.COCOA_SPREAD_TOAST).maxCount(64)));
    public static final Item MUSHROOM_SPREAD_TOAST = registerItem("mushroom_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.MUSHROOM_SPREAD_TOAST).maxCount(64)));
    public static final Item PORK_SPREAD_TOAST = registerItem("pork_spread_toast",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).food(ModFoodComponents.PORK_SPREAD_TOAST).maxCount(64)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Peculia.MOD_ID, name), item);
    }

    public static void registerModItems() {
    Peculia.LOGGER.info("Registering mod items for " + Peculia.MOD_ID);
    }

}
