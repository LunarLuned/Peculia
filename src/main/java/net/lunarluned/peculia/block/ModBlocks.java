package net.lunarluned.peculia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.custom.*;

import net.lunarluned.peculia.fluid.ModFluids;
import net.lunarluned.peculia.item.ModItemGroup;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //endded

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block POPROCK_CRYSTAL = registerBlock("poprock_crystal",
            new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.PINK).nonOpaque().strength(1f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);
    public static final Block POPROCK_BRICKS = registerBlock("poprock_bricks",
            new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.PINK).nonOpaque().strength(1.5f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);
    public static final Block CHISELED_POPROCK_BRICKS = registerBlock("chiseled_poprock_bricks",
            new Block(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.PINK).nonOpaque().strength(1.5f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);
    public static final Block POPROCK_BRICK_STAIRS = registerBlock("poprock_brick_stairs",
            new ModStairsBlock(ModBlocks.POPROCK_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.PINK).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);
    public static final Block POPROCK_BRICK_SLAB = registerBlock("poprock_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.PINK).strength(2f).nonOpaque().requiresTool().sounds(ModSoundEvents.POPROCKS)), ModItemGroup.PECULIA);
    public static final Block POPROCK_BRICK_WALL = registerBlock("poprock_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.PINK).strength(2f).requiresTool().sounds(ModSoundEvents.POPROCKS).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block MYTHRIL_CRYSTAL = registerBlock("mythril_crystal",
            new MythrilCrystalBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL), UniformIntProvider.create(3, 8)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICKS = registerBlock("mythril_bricks",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().nonOpaque().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_STAIRS = registerBlock("mythril_brick_stairs",
            new ModStairsBlock(ModBlocks.MYTHRIL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.LIGHT_BLUE_GRAY).nonOpaque().strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_SLAB = registerBlock("mythril_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.LIGHT_BLUE_GRAY).strength(2f).nonOpaque().requiresTool().sounds(ModSoundEvents.MYTHRIL)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_WALL = registerBlock("mythril_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.LIGHT_BLUE_GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.MYTHRIL).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block SILL = registerBlock("sill",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD).strength(2f).resistance(1)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICKS = registerBlock("sill_bricks",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD_BRICKS).strength(2f).resistance(1)), ModItemGroup.PECULIA);
    public static final Block CHISELED_SILL_BRICKS = registerBlock("chiseled_sill_bricks",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD_BRICKS).strength(2f).resistance(1)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_STAIRS = registerBlock("sill_brick_stairs",
            new ModStairsBlock(ModBlocks.SILL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_SLAB = registerBlock("sill_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_WALL = registerBlock("sill_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block SILL_TILES = registerBlock("sill_tiles",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD).strength(2f).resistance(1)), ModItemGroup.PECULIA);
    public static final Block SILL_TILE_STAIRS = registerBlock("sill_tile_stairs",
            new ModStairsBlock(ModBlocks.SILL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_TILE_SLAB = registerBlock("sill_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_TILE_WALL = registerBlock("sill_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);

    public static final Block FLUORITE = registerBlock("fluorite",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE = registerBlock("polished_fluorite",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_STAIRS = registerBlock("polished_fluorite_stairs",
            new ModStairsBlock(ModBlocks.POLISHED_FLUORITE.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_SLAB = registerBlock("polished_fluorite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_WALL = registerBlock("polished_fluorite_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE)), ModItemGroup.PECULIA);


    public static final Block POLISHED_FLUORITE_BRICKS = registerBlock("polished_fluorite_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_BRICK_STAIRS = registerBlock("polished_fluorite_brick_stairs",
            new ModStairsBlock(ModBlocks.POLISHED_FLUORITE_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_BRICK_SLAB = registerBlock("polished_fluorite_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_BRICK_WALL = registerBlock("polished_fluorite_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);

    public static final Block POLISHED_FLUORITE_PILLAR = registerBlock("polished_fluorite_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block CHISELED_POLISHED_FLUORITE = registerBlock("chiseled_polished_fluorite",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_TILES = registerBlock("polished_fluorite_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.CYAN).sounds(ModSoundEvents.FLUORITE_BRICKS).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_TILE_STAIRS = registerBlock("polished_fluorite_tile_stairs",
            new ModStairsBlock(ModBlocks.SILL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_TILE_SLAB = registerBlock("polished_fluorite_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);
    public static final Block POLISHED_FLUORITE_TILE_WALL = registerBlock("polished_fluorite_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(ModSoundEvents.FLUORITE_BRICKS)), ModItemGroup.PECULIA);


    public static final Block DARK_PURPUR = registerBlock("dark_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_PILLAR = registerBlock("dark_purpur_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block CHISELED_DARK_PURPUR = registerBlock("chiseled_dark_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_STAIRS = registerBlock("dark_purpur_stairs",
            new ModStairsBlock(ModBlocks.DARK_PURPUR.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_SLAB = registerBlock("dark_purpur_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_WALL = registerBlock("dark_purpur_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).strength(2f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block VOID_LAMP = registerBlock("void_lamp",
            new VoidLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP, MapColor.PALE_PURPLE).sounds(ModSoundEvents.VOID_LAMP).luminance(12).requiresTool().hardness(2f).strength(2f)), ModItemGroup.PECULIA);
    public static final Block CONDENSED_VOID = registerBlock("condensed_void",
            new CondensedVoidBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(ModSoundEvents.CONDENSED_VOID).resistance(9999).hardness(9999).noCollision().luminance(12).dropsNothing()), ModItemGroup.PECULIA);

    public static final Block SILLTAR_FLUID_BLOCK = registerBlockWithoutBlockItem("silltar_fluid",
            new ModFluidBlock(ModFluids.SILLTAR_STILL, FabricBlockSettings.of(Material.WATER).nonOpaque().noCollision().dropsNothing()), ModItemGroup.PECULIA);



    public static final Block ERODED_END_STONE = registerBlock("eroded_end_stone",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).strength(1f)), ModItemGroup.PECULIA);
    public static final Block CRUMBLING_END_STONE = registerBlock("crumbling_end_stone", new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(0f).resistance(0)), ModItemGroup.PECULIA);
    public static final Block DRAGONGLASS = registerBlock("dragonglass",
    new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);
    public static final Block DRAGONGLASS_PANE = registerBlock("dragonglass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);

    //nether
    public static final Block CRUMBLING_NETHERRACK = registerBlock("crumbling_netherrack", new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHERRACK).strength(0f).resistance(0)), ModItemGroup.PECULIA_NETHER);
    public static final Block ICHOR_MOLD_VEIN = registerBlock("ichor_mold_vein",
            new IchorMoldVeinBlock(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.NETHER_WART).nonOpaque().strength(0.1f)), ModItemGroup.PECULIA_NETHER);
    public static final Block ICHOR_MOLD = registerBlock("ichor_mold",
            new Block(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.NETHER_WART).strength(1f)), ModItemGroup.PECULIA_NETHER);
    public static final Block ICHOR_NYLIUM = registerBlock("ichor_nylium",
            new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHERRACK).strength(1f)), ModItemGroup.PECULIA_NETHER);
    public static final Block ICHOR_STICKER = registerBlock("ichor_sticker",
            new IchorStickerBlock(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.NETHER_WART).nonOpaque().luminance(15).strength(1f)), ModItemGroup.PECULIA_NETHER);
    //overworld
    public static final Block SCULK_SPINE = registerBlock("sculk_spine",
            new SculkPillarBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SCULK_CATALYST).requiresTool().resistance(1).strength(2f),
            UniformIntProvider.create(2, 8)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_PILLAR = registerBlock("spinal_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block CHISELED_SPINAL_BRICKS = registerBlock("chiseled_spinal_bricks",
            new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_BRICKS = registerBlock("spinal_bricks",
            new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_BRICK_STAIRS = registerBlock("spinal_brick_stairs",
            new ModStairsBlock(ModBlocks.SPINAL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_BRICK_SLAB = registerBlock("spinal_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_BRICK_WALL = registerBlock("spinal_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_TILES = registerBlock("spinal_tiles",
            new Block(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SCULK_CATALYST).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_TILE_STAIRS = registerBlock("spinal_tile_stairs",
            new ModStairsBlock(ModBlocks.SPINAL_TILES.getDefaultState(),FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_TILE_SLAB = registerBlock("spinal_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SPINAL_TILE_WALL = registerBlock("spinal_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.SCULK).mapColor(MapColor.OFF_WHITE).strength(1f).strength(2f).requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block CRUMBLING_STONE = registerBlock("crumbling_stone", new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(0.0f).resistance(0)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block CRUMBLING_DEEPSLATE = registerBlock("crumbling_deepslate", new CrumblingBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.DEEPSLATE).strength(0.1f).resistance(0)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(6)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block CONTAINED_COBBLESTONE = registerBlock("contained_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block CONTINENTAL_COBBLESTONE = registerBlock("continental_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(18)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block ANOMALAIC_COBBLESTONE = registerBlock("anomalaic_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(24)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block AWAKENED_COBBLESTONE = registerBlock("awakened_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(30)), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block FERROCK = registerBlock("ferrock",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().mapColor(MapColor.BROWN).sounds(BlockSoundGroup.ANCIENT_DEBRIS).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block CHARGED_FERROCK = registerBlock("charged_ferrock",
            new ChargedFerrockBlock(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool().luminance(3).mapColor(MapColor.BROWN).sounds(BlockSoundGroup.ANCIENT_DEBRIS).resistance(12)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK = registerBlock("refined_ferrock",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool().mapColor(MapColor.BROWN).sounds(BlockSoundGroup.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_BRICKS = registerBlock("refined_ferrock_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().mapColor(MapColor.BROWN).sounds(BlockSoundGroup.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_BRICK_STAIRS = registerBlock("refined_ferrock_brick_stairs",
            new ModStairsBlock(ModBlocks.REFINED_FERROCK_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_BRICK_SLAB = registerBlock("refined_ferrock_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).nonOpaque().requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_BRICK_WALL = registerBlock("refined_ferrock_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_TILES = registerBlock("refined_ferrock_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).resistance(10)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_TILE_STAIRS = registerBlock("refined_ferrock_tile_stairs",
            new ModStairsBlock(ModBlocks.REFINED_FERROCK_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_TILE_SLAB = registerBlock("refined_ferrock_tile_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).nonOpaque().requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block REFINED_FERROCK_TILE_WALL = registerBlock("refined_ferrock_tile_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(4f).resistance(10).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);

    public static final Block SNOW_BRICKS = registerBlock("snow_bricks",
            new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SNOW).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SNOW_BRICK_PILLAR = registerBlock("snow_brick_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.SNOW_BLOCK).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.SNOW).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SNOW_BRICK_STAIRS = registerBlock("snow_brick_stairs",
            new ModStairsBlock(Blocks.SNOW_BLOCK.getDefaultState(),FabricBlockSettings.of(Material.SNOW_BLOCK).mapColor(MapColor.OFF_WHITE).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.SNOW)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SNOW_BRICK_SLAB = registerBlock("snow_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SNOW_BLOCK).mapColor(MapColor.OFF_WHITE).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.SNOW)), ModItemGroup.PECULIA_OVERWORLD);
    public static final Block SNOW_BRICK_WALL = registerBlock("snow_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.SNOW_BLOCK).mapColor(MapColor.OFF_WHITE).strength(2f).requiresTool().sounds(BlockSoundGroup.SNOW).nonOpaque()), ModItemGroup.PECULIA_OVERWORLD);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Peculia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Peculia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(Peculia.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Peculia.LOGGER.info("Registering mod blocks for " + Peculia.MOD_ID);
    }
}
