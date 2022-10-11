package net.lunarluned.peculia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.custom.*;
import net.lunarluned.peculia.item.ModItemGroup;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {

    // End Blocks

    public static final Block POPROCK_CRYSTAL = registerBlock("poprock_crystal",
    new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_PINK).nonOpaque().strength(1f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);

    public static final Block POPROCK_BRICKS = registerBlock("poprock_bricks",
    new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_PINK).nonOpaque().strength(1.5f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);

    public static final Block CHISELED_POPROCK_BRICKS = registerBlock("chiseled_poprock_bricks",
    new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_PINK).nonOpaque().strength(1.5f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);

    public static final Block POPROCK_BRICK_STAIRS = registerBlock("poprock_brick_stairs",
    new ModStairsBlock(ModBlocks.POPROCK_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_PINK).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);

    public static final Block POPROCK_BRICK_SLAB = registerBlock("poprock_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_PINK).strength(2f).nonOpaque().requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);

    public static final Block POPROCK_BRICK_WALL = registerBlock("poprock_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MaterialColor.COLOR_PINK).strength(2f).requiresTool().sounds(ModSoundEvents.POPROCKS).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
    new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().sounds(SoundType.METAL)), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_CRYSTAL = registerBlock("mythril_crystal",
    new MythrilCrystalBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL), UniformInt.of(2, 8)), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_BRICKS = registerBlock("mythril_bricks",
    new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().nonOpaque().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_BRICK_STAIRS = registerBlock("mythril_brick_stairs",
    new ModStairsBlock(ModBlocks.MYTHRIL_BRICKS.defaultBlockState(),FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_LIGHT_BLUE).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_BRICK_SLAB = registerBlock("mythril_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_LIGHT_BLUE).strength(2f).nonOpaque().requiresTool().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_BRICK_WALL = registerBlock("mythril_brick_wall",
    new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
    .mapColor(MaterialColor.COLOR_LIGHT_BLUE).strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block CHISELED_MYTHRIL = registerBlock("chiseled_mythril",
    new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MaterialColor.COLOR_LIGHT_BLUE).nonOpaque().strength(1.5f).requiresTool().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);

    public static final Block SILL = registerBlock("sill",
    new SillBlock(FabricBlockSettings.of(Material.CLAY).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.MUD).strength(2f).resistance(1)), ModItemGroup.PECULIA);

    public static final Block SILL_BRICKS = registerBlock("sill_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.MUD_BRICKS).strength(2f).resistance(1)), ModItemGroup.PECULIA);

    public static final Block SILL_BRICK_STAIRS = registerBlock("sill_brick_stairs",
    new ModStairsBlock(ModBlocks.SILL_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).nonOpaque().strength(2f).requiresTool().sounds(SoundType.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block SILL_BRICK_SLAB = registerBlock("sill_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).nonOpaque().requiresTool().sounds(SoundType.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block SILL_BRICK_WALL = registerBlock("sill_brick_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.MUD_BRICKS).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block CHISELED_SILL_BRICKS = registerBlock("chiseled_sill_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.MUD_BRICKS).strength(2f).resistance(1)), ModItemGroup.PECULIA);

    public static final Block SILL_TILES = registerBlock("sill_tiles",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.MUD_BRICKS).strength(2f).resistance(1)), ModItemGroup.PECULIA);

    public static final Block SILL_TILE_STAIRS = registerBlock("sill_tile_stairs",
    new ModStairsBlock(ModBlocks.SILL_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block SILL_TILE_SLAB = registerBlock("sill_tile_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block SILL_TILE_WALL = registerBlock("sill_tile_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block FLUORITE = registerBlock("fluorite",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE = registerBlock("polished_fluorite",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_STAIRS = registerBlock("polished_fluorite_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_FLUORITE.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_SLAB = registerBlock("polished_fluorite_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_WALL = registerBlock("polished_fluorite_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_BRICKS = registerBlock("polished_fluorite_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_BRICK_STAIRS = registerBlock("polished_fluorite_brick_stairs",
    new ModStairsBlock(ModBlocks.POLISHED_FLUORITE_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_BRICK_SLAB = registerBlock("polished_fluorite_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_BRICK_WALL = registerBlock("polished_fluorite_brick_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_PILLAR = registerBlock("polished_fluorite_pillar",
    new RotatedPillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block CHISELED_POLISHED_FLUORITE = registerBlock("chiseled_polished_fluorite",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_TILES = registerBlock("polished_fluorite_tiles",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_TILE_STAIRS = registerBlock("polished_fluorite_tile_stairs",
    new ModStairsBlock(ModBlocks.SILL_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_TILE_SLAB = registerBlock("polished_fluorite_tile_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_TILE_WALL = registerBlock("polished_fluorite_tile_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_CYAN).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR = registerBlock("dark_purpur",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).sounds(SoundType.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR_PILLAR = registerBlock("dark_purpur_pillar",
    new RotatedPillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).sounds(SoundType.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block CHISELED_DARK_PURPUR = registerBlock("chiseled_dark_purpur",
    new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).sounds(SoundType.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR_STAIRS = registerBlock("dark_purpur_stairs",
    new ModStairsBlock(ModBlocks.DARK_PURPUR.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).strength(2f).requiresTool().sounds(SoundType.STONE)), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR_SLAB = registerBlock("dark_purpur_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).strength(2f).nonOpaque().requiresTool().sounds(SoundType.STONE)), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR_WALL = registerBlock("dark_purpur_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).strength(2f).requiresTool().sounds(SoundType.STONE).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block VOID_LAMP = registerBlock("void_lamp",
    new VoidLampBlock(FabricBlockSettings.of(Material.BUILDABLE_GLASS, MaterialColor.COLOR_PURPLE).sounds(ModSoundEvents.VOID_LAMP).luminance(12).requiresTool().hardness(2f).strength(2f)), ModItemGroup.PECULIA);

    public static final Block CONDENSED_VOID = registerBlock("condensed_void",
    new CondensedVoidBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_PURPLE).sounds(ModSoundEvents.CONDENSED_VOID).resistance(9999).hardness(9999).noCollision().luminance(12).noLootTable()), ModItemGroup.PECULIA);

    public static final Block ERODED_END_STONE = registerBlock("eroded_end_stone",
    new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).strength(1f)), ModItemGroup.PECULIA);

    public static final Block CRUMBLING_END_STONE = registerBlock("crumbling_end_stone",
    new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.STONE).strength(0f).resistance(0)), ModItemGroup.PECULIA);

    public static final Block DRAGONGLASS = registerBlock("dragonglass",
    new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);

    public static final Block DRAGONGLASS_PANE = registerBlock("dragonglass_pane",
    new IronBarsBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);







    // nether blocks

    public static final Block CRUMBLING_NETHERRACK = registerBlock("crumbling_netherrack",
    new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.NETHERRACK).strength(0f).resistance(0)), ModItemGroup.PECULIA_NETHER);

    public static final Block ICHOR_MOLD_VEIN = registerBlock("ichor_mold_vein",
    new GenericMultifaceBlock(FabricBlockSettings.of(Material.PLANT).sounds(SoundType.WART_BLOCK).noCollision().nonOpaque().strength(0.1f)), ModItemGroup.PECULIA_NETHER);

    public static final Block ICHOR_MOLD = registerBlock("ichor_mold",
    new Block(FabricBlockSettings.of(Material.PLANT).sounds(SoundType.WART_BLOCK).strength(1f)), ModItemGroup.PECULIA_NETHER);

    public static final Block ICHOR_NYLIUM = registerBlock("ichor_nylium",
    new IchorNyliumBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.NYLIUM).strength(1f)), ModItemGroup.PECULIA_NETHER);

    public static final Block ICHOR_STICKER = registerBlock("ichor_sticker",
    new IchorStickerBlock(FabricBlockSettings.of(Material.PLANT).sounds(SoundType.WART_BLOCK).nonOpaque().luminance(15).strength(1f)), ModItemGroup.PECULIA_NETHER);

    public static final Block PERFORATED_FLESH = registerBlock("perforated_flesh",
    new Block(FabricBlockSettings.of(Material.STONE).sounds(SoundType.WART_BLOCK).strength(3f).requiresTool()), ModItemGroup.PECULIA_NETHER);

    public static final Block TITAN_BLOOD = registerBlockWithoutBlockItem("titan_blood",
    new TitanBloodBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.HONEY_BLOCK).noCollision().strength(5f).luminance(15).requiresTool()));

    public static final Block PERFORATED_JAW = registerBlock("perforated_jaw",
    new PerforatedJawBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.WART_BLOCK).strength(5.5f).hardness(1).requiresTool()), ModItemGroup.PECULIA_NETHER);

    public static final Block PERFORATED_PUSTULE = registerBlock("perforated_pustule",
    new PerforatedPustuleBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.WART_BLOCK).nonOpaque().luminance(15).strength(0.5f)), ModItemGroup.PECULIA_NETHER);

    public static final Block ARTERIAL_BRAMBLE = registerBlock("arterial_bramble",
    new ArterialBrambleBlock(FabricBlockSettings.of(Material.PLANT).sounds(SoundType.WART_BLOCK).nonOpaque().noCollision()), ModItemGroup.PECULIA_NETHER);

    public static final Block SANGUINE_QUARTZ_BLOCK = registerBlock("sanguine_quartz_block",
    new SanguineQuartzBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL), UniformInt.of(2, 8)), ModItemGroup.PECULIA_NETHER);







    // overworld blocks

    public static final Block SCULK_SPINE = registerBlock("sculk_spine",
    new SculkPillarBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.SCULK_CATALYST).requiresTool().resistance(1).strength(2f),
    UniformInt.of(2, 8)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SCULK_SAC_BLOCK = registerBlock("sculk_sac_block",
    new SculkSacBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.COLOR_BLACK).sounds(SoundType.SCULK).requiresTool().resistance(0).strength(.1f),
    UniformInt.of(12, 38)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_PILLAR = registerBlock("spinal_pillar",
    new RotatedPillarBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CHISELED_SPINAL_BRICKS = registerBlock("chiseled_spinal_bricks",
    new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_BRICKS = registerBlock("spinal_bricks",
    new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_BRICK_STAIRS = registerBlock("spinal_brick_stairs",
    new ModStairsBlock(ModBlocks.SPINAL_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_BRICK_SLAB = registerBlock("spinal_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(SoundType.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_BRICK_WALL = registerBlock("spinal_brick_wall",
    new WallBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.SCULK_CATALYST).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_TILES = registerBlock("spinal_tiles",
    new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_TILE_STAIRS = registerBlock("spinal_tile_stairs",
    new ModStairsBlock(ModBlocks.SPINAL_TILES.defaultBlockState(),
    FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_TILE_SLAB = registerBlock("spinal_tile_slab",
    new SlabBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(SoundType.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SPINAL_TILE_WALL = registerBlock("spinal_tile_wall",
    new WallBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.SCULK_CATALYST).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CRUMBLING_STONE = registerBlock("crumbling_stone",
    new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.STONE).strength(0.0f).resistance(0)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CRUMBLING_DEEPSLATE = registerBlock("crumbling_deepslate",
    new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(SoundType.DEEPSLATE).strength(0.1f).resistance(0)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool().sounds(SoundType.STONE).resistance(6)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CONTAINED_COBBLESTONE = registerBlock("contained_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(SoundType.STONE).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CONTINENTAL_COBBLESTONE = registerBlock("continental_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool().sounds(SoundType.STONE).resistance(18)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block ANOMALAIC_COBBLESTONE = registerBlock("anomalaic_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).strength(7f).requiresTool().sounds(SoundType.STONE).resistance(24)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block AWAKENED_COBBLESTONE = registerBlock("awakened_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).strength(8f).requiresTool().sounds(SoundType.STONE).resistance(30)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block FERROCK = registerBlock("ferrock",
    new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().mapColor(MaterialColor.COLOR_BROWN).sounds(SoundType.ANCIENT_DEBRIS).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CHARGED_FERROCK = registerBlock("charged_ferrock",
    new ChargedFerrockBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().luminance(3).mapColor(MaterialColor.COLOR_BROWN).sounds(SoundType.ANCIENT_DEBRIS).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK = registerBlock("refined_ferrock",
    new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool().mapColor(MaterialColor.COLOR_BROWN).sounds(SoundType.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_BRICKS = registerBlock("refined_ferrock_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().mapColor(MaterialColor.COLOR_BROWN).sounds(SoundType.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_BRICK_STAIRS = registerBlock("refined_ferrock_brick_stairs",
    new ModStairsBlock(ModBlocks.REFINED_FERROCK_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).requiresTool().sounds(SoundType.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_BRICK_SLAB = registerBlock("refined_ferrock_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).nonOpaque().requiresTool().sounds(SoundType.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_BRICK_WALL = registerBlock("refined_ferrock_brick_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).requiresTool().sounds(SoundType.ANCIENT_DEBRIS).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_TILES = registerBlock("refined_ferrock_tiles",
    new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(SoundType.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_TILE_STAIRS = registerBlock("refined_ferrock_tile_stairs",
    new ModStairsBlock(ModBlocks.REFINED_FERROCK_BRICKS.defaultBlockState(),
    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).requiresTool().sounds(SoundType.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_TILE_SLAB = registerBlock("refined_ferrock_tile_slab",
    new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).nonOpaque().requiresTool().sounds(SoundType.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block REFINED_FERROCK_TILE_WALL = registerBlock("refined_ferrock_tile_wall",
    new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_BROWN).strength(4f).resistance(10).requiresTool().sounds(SoundType.ANCIENT_DEBRIS).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICKS = registerBlock("snow_bricks",
    new Block(FabricBlockSettings.of(Material.SNOW).mapColor(MaterialColor.SNOW).sounds(SoundType.SNOW).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICK_PILLAR = registerBlock("snow_brick_pillar",
    new RotatedPillarBlock(FabricBlockSettings.of(Material.SNOW).mapColor(MaterialColor.SNOW).sounds(SoundType.SNOW).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICK_STAIRS = registerBlock("snow_brick_stairs",
    new ModStairsBlock(Blocks.SNOW_BLOCK.defaultBlockState(),
    FabricBlockSettings.of(Material.SNOW).mapColor(MaterialColor.SNOW).nonOpaque().strength(2f).requiresTool().sounds(SoundType.SNOW)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICK_SLAB = registerBlock("snow_brick_slab",
    new SlabBlock(FabricBlockSettings.of(Material.SNOW).mapColor(MaterialColor.SNOW).strength(2f).nonOpaque().requiresTool().sounds(SoundType.SNOW)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICK_WALL = registerBlock("snow_brick_wall",
    new WallBlock(FabricBlockSettings.of(Material.SNOW).mapColor(MaterialColor.SNOW).strength(2f).requiresTool().sounds(SoundType.SNOW).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_PILLAR = registerBlock("bone_pillar",
            new RotatedPillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.BONE_BLOCK).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_BRICKS = registerBlock("bone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.BONE_BLOCK).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_BRICK_STAIRS = registerBlock("bone_brick_stairs",
            new ModStairsBlock(ModBlocks.BONE_BRICKS.defaultBlockState(),
                    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.BONE_BLOCK)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_BRICK_SLAB = registerBlock("bone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(SoundType.BONE_BLOCK)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_BRICK_WALL = registerBlock("bone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.BONE_BLOCK).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_TILES = registerBlock("bone_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).sounds(SoundType.BONE_BLOCK).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_TILE_STAIRS = registerBlock("bone_tile_stairs",
            new ModStairsBlock(ModBlocks.BONE_TILES.defaultBlockState(),
                    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.BONE_BLOCK)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_TILE_SLAB = registerBlock("bone_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(SoundType.BONE_BLOCK)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block BONE_TILE_WALL = registerBlock("bone_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.TERRACOTTA_WHITE).strength(1f).strength(2f).requiresTool().sounds(SoundType.BONE_BLOCK).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);


//misc

    public static final Block GRAVESTONE = registerBlock("gravestone",
    new GravestoneBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE).requiresTool().resistance(2).strength(3f)), ModItemGroup.PECULIA_MISC);

    public static final Block CORPOREUM_SOUL_SAND = registerBlock("corporeum_soul_sand",
            new CorporeumSoulSandBlock(FabricBlockSettings.of(Material.SAND).mapColor(MaterialColor.COLOR_BROWN).sounds(SoundType.SOUL_SAND).resistance(1).strength(1f)), ModItemGroup.PECULIA_NETHER);

    public static final Block CRYPTSTONE = registerBlock("cryptstone",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE = registerBlock("polished_cryptstone",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_STAIRS = registerBlock("polished_cryptstone_stairs",
            new ModStairsBlock(ModBlocks.POLISHED_FLUORITE.defaultBlockState(),
                    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_SLAB = registerBlock("polished_cryptstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_WALL = registerBlock("polished_cryptstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_BRICKS = registerBlock("polished_cryptstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_BRICK_STAIRS = registerBlock("polished_cryptstone_brick_stairs",
            new ModStairsBlock(ModBlocks.POLISHED_FLUORITE_BRICKS.defaultBlockState(),
                    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_BRICKS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_BRICK_SLAB = registerBlock("polished_cryptstone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_BRICKS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_BRICK_WALL = registerBlock("polished_cryptstone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_BRICKS)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_PILLAR = registerBlock("polished_cryptstone_pillar",
            new RotatedPillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_TILES = registerBlock("polished_cryptstone_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).sounds(SoundType.DEEPSLATE_TILES).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_TILE_STAIRS = registerBlock("polished_cryptstone_tile_stairs",
            new ModStairsBlock(ModBlocks.SILL_BRICKS.defaultBlockState(),
                    FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_TILES)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_TILE_SLAB = registerBlock("polished_cryptstone_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_TILES)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block POLISHED_CRYPTSTONE_TILE_WALL = registerBlock("polished_cryptstone_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MaterialColor.COLOR_GRAY).strength(2f).requiresTool().sounds(SoundType.DEEPSLATE_TILES)), ModItemGroup.PECULIA_OVERWORLD);











    private static Block registerBlock(String name, Block block, CreativeModeTab group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new ResourceLocation(Peculia.MOD_ID, name), block);
    }



    private static Item registerBlockItem(String name, Block block, CreativeModeTab group) {
        return Registry.register(Registry.ITEM, new ResourceLocation(Peculia.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings().tab(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(Peculia.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Peculia.LOGGER.info("Registering mod blocks for " + Peculia.MOD_ID);
    }
}
