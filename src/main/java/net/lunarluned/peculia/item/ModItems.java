package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.ModBlocks;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.item.custom.*;
import net.lunarluned.peculia.item.custom.elixirs.*;
import net.lunarluned.peculia.item.custom.glyphs.*;
import net.lunarluned.peculia.item.custom.scythes.GenericScytheItem;
import net.lunarluned.peculia.item.custom.scythes.JailorsScytheItem;
import net.lunarluned.peculia.item.custom.scythes.SoulScytheItem;
import net.lunarluned.peculia.item.custom.tomes.*;
import net.lunarluned.peculia.item.custom.tomes.agility.AgilityTomeItem;
import net.lunarluned.peculia.item.custom.tomes.agility.LesserAgilityTomeItem;
import net.lunarluned.peculia.item.custom.tomes.empowering.EmpoweringTomeItem;
import net.lunarluned.peculia.item.custom.tomes.empowering.LesserEmpoweringTomeItem;
import net.lunarluned.peculia.item.custom.tomes.fortifying.FortifyingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.fortifying.LesserFortifyingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.harvesting.LesserHarvestingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.healing.HealingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.healing.LesserHealingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.agility.InvertedAgilityTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.agility.LesserInvertedAgilityTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.empowering.InvertedEmpoweringTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.empowering.LesserInvertedEmpoweringTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.fortifying.InvertedFortifyingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.fortifying.LesserInvertedFortifyingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.healing.InvertedHealingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.healing.LesserInvertedHealingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.updraft.InvertedUpdraftTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.updraft.LesserInvertedUpdraftTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.watching.InvertedWatchingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.inverted.watching.LesserInvertedWatchingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.updraft.LesserUpdraftTomeItem;
import net.lunarluned.peculia.item.custom.tomes.updraft.UpdraftTomeItem;
import net.lunarluned.peculia.item.custom.tomes.harvesting.HarvestingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.watching.LesserWatchingTomeItem;
import net.lunarluned.peculia.item.custom.tomes.watching.WatchingTomeItem;
import net.lunarluned.peculia.item.modmats.ModArmorMaterials;
import net.lunarluned.peculia.item.modmats.ModFoodComponents;
import net.lunarluned.peculia.item.modmats.ModToolMaterials;
import net.lunarluned.peculia.misc.PeculiaTags;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class ModItems {

    // Misc Items

    public static final Item FALLEN_HERO_DAGGER = registerItem("fallen_hero_dagger",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item FALLEN_HERO_SWORD = registerItem("fallen_hero_sword",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item PECULIAR_DAGGER = registerItem("peculiar_dagger",
    new PeculiarDaggerItem(ModToolMaterials.PECULIAR,3, -2.0f,new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item PECULIAR_SWORD = registerItem("peculiar_sword",
    new PeculiarSwordItem(ModToolMaterials.PECULIAR,5, -2.5f,new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item ANTIDOTE_ELIXIR = registerItem("antidote_elixir",
    new AntidoteElixirItem(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(8).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item EMPOWERING_ELIXIR = registerItem("empowering_elixir",
    new EmpoweringElixirItem(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(8).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item GROUNDED_ELIXIR = registerItem("grounded_elixir",
    new GroundedElixirItem(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(8).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item SATIATED_ELIXIR = registerItem("satiated_elixir",
    new SatiatedElixirItem(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(8).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item VISUALITY_ELIXIR = registerItem("visuality_elixir",
    new VisualityElixirItem(new FabricItemSettings().group(ModItemGroup.PECULIA_MISC).maxCount(8).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item GHOST_SPAWN_EGG = registerItem("ghost_spawn_egg",
    new SpawnEggItem(ModEntities.GHOST, 8122868, 3483938, new Item.Properties().tab(ModItemGroup.PECULIA_MISC)));

    public static final Item WISP_SPAWN_EGG = registerItem("wisp_spawn_egg",
    new SpawnEggItem(ModEntities.WISP, 3483938, 8122868, new Item.Properties().tab(ModItemGroup.PECULIA_MISC)));



    public static final Item SOUL = registerItem("soul",
    new SoulItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.UNCOMMON)));

    public static final Item CORPOREUM_FRAGMENT = registerItem("corporeum_fragment",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item BUCKET_OF_AGONY = registerItem("bucket_of_agony",
    new Item(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item REMNANT = registerItem("remnant",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item ECTOPLASM = registerItem("ectoplasm",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.UNCOMMON)));

    public static final Item REMNANT_HEART = registerItem("remnant_heart",
    new RemnantHeartItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_TOME = registerItem("inactive_tome",
    new ModTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item INACTIVE_HEALING_TOME = registerItem("inactive_healing_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_HEALING = registerItem("lesser_tome_of_healing",
    new LesserHealingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_HEALING = registerItem("tome_of_healing",
    new HealingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_HEALING = registerItem("lesser_inverted_tome_of_healing",
    new LesserInvertedHealingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_HEALING = registerItem("inverted_tome_of_healing",
    new InvertedHealingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_UPDRAFT_TOME = registerItem("inactive_updraft_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_UPDRAFT = registerItem("lesser_tome_of_updraft",
    new LesserUpdraftTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_UPDRAFT = registerItem("tome_of_updraft",
    new UpdraftTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_UPDRAFT = registerItem("lesser_inverted_tome_of_updraft",
    new LesserInvertedUpdraftTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_UPDRAFT = registerItem("inverted_tome_of_updraft",
    new InvertedUpdraftTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_EMPOWERING_TOME = registerItem("inactive_empowering_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_EMPOWERING = registerItem("lesser_tome_of_empowering",
    new LesserEmpoweringTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_EMPOWERING = registerItem("tome_of_empowering",
    new EmpoweringTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_EMPOWERING = registerItem("lesser_inverted_tome_of_empowering",
    new LesserInvertedEmpoweringTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_EMPOWERING = registerItem("inverted_tome_of_empowering",
    new InvertedEmpoweringTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_AGILITY_TOME = registerItem("inactive_agility_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_AGILITY = registerItem("lesser_tome_of_agility",
    new LesserAgilityTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_AGILITY = registerItem("tome_of_agility",
    new AgilityTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_AGILITY = registerItem("lesser_inverted_tome_of_agility",
    new LesserInvertedAgilityTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_AGILITY = registerItem("inverted_tome_of_agility",
    new InvertedAgilityTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_FORTIFYING_TOME = registerItem("inactive_fortifying_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_FORTIFYING = registerItem("lesser_tome_of_fortifying",
    new LesserFortifyingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_FORTIFYING = registerItem("tome_of_fortifying",
    new FortifyingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_FORTIFYING = registerItem("lesser_inverted_tome_of_fortifying",
    new LesserInvertedFortifyingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_FORTIFYING = registerItem("inverted_tome_of_fortifying",
    new InvertedFortifyingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INACTIVE_WATCHING_TOME = registerItem("inactive_watching_tome",
    new ModTomeItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item LESSER_TOME_OF_WATCHING = registerItem("lesser_tome_of_watching",
    new LesserWatchingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_WATCHING = registerItem("tome_of_watching",
    new WatchingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_INVERTED_TOME_OF_WATCHING = registerItem("lesser_inverted_tome_of_watching",
    new LesserInvertedWatchingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item INVERTED_TOME_OF_WATCHING = registerItem("inverted_tome_of_watching",
    new InvertedWatchingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item LESSER_TOME_OF_HARVESTING = registerItem("lesser_tome_of_harvesting",
            new LesserHarvestingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TOME_OF_HARVESTING = registerItem("tome_of_harvesting",
    new HarvestingTomeItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item CLOAK_HELMET = registerItem("cloak_helmet",
    new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.HEAD,
    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item CLOAK_CHESTPLATE = registerItem("cloak_chestplate",
    new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.CHEST,
    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item CLOAK_LEGGINGS = registerItem("cloak_leggings",
    new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.LEGS,
    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item ECTO_CLOAK_HELMET = registerItem("ecto_cloak_helmet",
            new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item ECTO_CLOAK_CHESTPLATE = registerItem("ecto_cloak_chestplate",
            new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item ECTO_CLOAK_LEGGINGS = registerItem("ecto_cloak_leggings",
            new ArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE)));

    public static final Item HEALING_GLYPH = registerItem("healing_glyph",
    new HealingGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item AGILITY_GLYPH = registerItem("agility_glyph",
    new AgilityGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item UPDRAFT_GLYPH = registerItem("updraft_glyph",
    new UpdraftGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item EMPOWERING_GLYPH = registerItem("empowering_glyph",
    new EmpoweringGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item FORTIFYING_GLYPH = registerItem("fortifying_glyph",
    new FortifyingGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    public static final Item WATCHING_GLYPH = registerItem("watching_glyph",
    new WatchingGlyphItem(new FabricItemSettings().group(ModItemGroup.PECULIA_ARCANE).rarity(Rarity.COMMON)));

    // End Items

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
    new GenericScytheItem(ModToolMaterials.MYTHRIL, 4, -2.5f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));

    public static final Item MYTHRIL_HALBERD = registerItem("mythril_halberd",
    new ModAxeItem(ModToolMaterials.MYTHRIL,8, -3.1f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));

    public static final Item MYTHRIL_HAMMER = registerItem("mythril_hammer",
    new ModPickaxeItem(ModToolMaterials.MYTHRIL, 9, -3.4f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));

    public static final Item MYTHRIL_SPEAREL = registerItem("mythril_spearel",
    new ModShovelItem(ModToolMaterials.MYTHRIL, 2, -2.4f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));

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

    public static final Item DISC_FRAGMENT_LULLA = registerItem("disc_fragment_lulla",
    new DiscFragmentItem(new FabricItemSettings().group(ModItemGroup.PECULIA)));

    public static final Item MUSIC_DISC_LULLA = registerItem("music_disc_lulla",
    new ModMusicDiscItem(7, ModSoundEvents.MUSIC_DISC_LULLA,
    new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).group(ModItemGroup.PECULIA), 194));

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

    // Nether Items

    public static final Item AMBROSIA = registerItem("ambrosia",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).rarity(Rarity.RARE).food(ModFoodComponents.AMBROSIA).maxCount(64)));

    public static final Item HOGLIN_TUSK = registerItem("hoglin_tusk",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));

    public static final Item SANGUINE_QUARTZ = registerItem("sanguine_quartz",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));

    public static final Item SANGUINE_QUARTZ_FRAGMENT = registerItem("sanguine_quartz_fragment",
    new Item(new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));

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
    new ModGauntletItem(Tiers.NETHERITE, 3, -2.209f, new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));

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

    public static final Item BOTTLE_OF_TITAN_BLOOD = registerItem("bottle_of_titan_blood",
    new BottleOfTitansBloodItem(ModBlocks.TITAN_BLOOD, new FabricItemSettings().maxCount(16).group(ModItemGroup.PECULIA_NETHER)));

    public static final Item SPORODINE = registerItem("sporodine",
    new Item(new FabricItemSettings().fireproof().group(ModItemGroup.PECULIA_NETHER)));

    public static final Item HOG_HORN = registerItem("hog_horn",
    new HogHornItem(new FabricItemSettings().tab(ModItemGroup.PECULIA_NETHER).stacksTo(1), PeculiaTags.HOG_HORNS));

    public static final Item MOLDLEAP_BOOTS = registerItem("moldleap_boots",
    new ArmorItem(ModArmorMaterials.MOLDLEAP, EquipmentSlot.FEET,
    new FabricItemSettings().group(ModItemGroup.PECULIA_NETHER)));

    public static final Item MOLDSPAWN_SPAWN_EGG = registerItem("moldspawn_spawn_egg",
    new SpawnEggItem(ModEntities.MOLDSPAWN, 8343348, 5974563, new Item.Properties().tab(ModItemGroup.PECULIA_NETHER)));

    // Overworld Items

    public static final Item GOLDEN_GAUNTLET = registerItem("golden_gauntlet",
    new ModGauntletItem(Tiers.GOLD, 3, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD)));

    public static final Item IRON_GAUNTLET = registerItem("iron_gauntlet",
    new ModGauntletItem(Tiers.IRON, 2, -2.3f,  new FabricItemSettings().tab(ModItemGroup.PECULIA_OVERWORLD)));

    public static final Item DIAMOND_GAUNTLET = registerItem("diamond_gauntlet",
    new ModGauntletItem(Tiers.DIAMOND, 2, -2.2f, new FabricItemSettings().tab(ModItemGroup.PECULIA_OVERWORLD)));

    public static final Item COPPER_CLEAVER = registerItem("copper_cleaver",
    new ModDaggerItem(ModToolMaterials.COPPER,1, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item GILDED_COPPER_CLEAVER = registerItem("gilded_copper_cleaver",
    new ModDaggerItem(ModToolMaterials.COPPER,2, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item CHARGED_COPPER_CLEAVER = registerItem("charged_copper_cleaver",
    new ElectrocutedItem(ModToolMaterials.COPPER,0, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item CHARGED_GILDED_COPPER_CLEAVER = registerItem("charged_gilded_copper_cleaver",
    new ElectrocutedItem(ModToolMaterials.COPPER,1, -2.0f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item SOUL_SCYTHE = registerItem("soul_scythe",
    new SoulScytheItem(ModToolMaterials.SCYTHE, 4, -2.4f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

    public static final Item JAILORS_SCYTHE = registerItem("jailors_scythe",
    new JailorsScytheItem(ModToolMaterials.SCYTHE, 6, -2.2f, new FabricItemSettings().group(ModItemGroup.PECULIA_OVERWORLD).maxCount(1)));

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

    public static final Item COAL_GEODE_SPAWN_EGG = registerItem("coal_geode_spawn_egg",
            new SpawnEggItem(ModEntities.COAL_GEODE, 7631988, 3552822, new Item.Properties().tab(ModItemGroup.PECULIA_OVERWORLD)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(Peculia.MOD_ID, name), item);
    }

    public static void registerModItems() {
    Peculia.LOGGER.info("Registering mod items for " + Peculia.MOD_ID);
    }

}
