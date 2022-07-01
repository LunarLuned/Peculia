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
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD).resistance(1)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICKS = registerBlock("sill_bricks",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD_BRICKS).resistance(1)), ModItemGroup.PECULIA);
    public static final Block CHISELED_SILL_BRICKS = registerBlock("chiseled_sill_bricks",
            new SillBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.MUD_BRICKS).resistance(1)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_STAIRS = registerBlock("sill_brick_stairs",
            new ModStairsBlock(ModBlocks.SILL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_SLAB = registerBlock("sill_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.MUD_BRICKS)), ModItemGroup.PECULIA);
    public static final Block SILL_BRICK_WALL = registerBlock("sill_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.MUD_BRICKS).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block DARK_PURPUR = registerBlock("dark_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_PILLAR = registerBlock("dark_purpur_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block CHISELED_DARK_PURPUR = registerBlock("chiseled_dark_purpur",
            new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.STONE).requiresTool().resistance(1).strength(2f)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_STAIRS = registerBlock("dark_purpur_stairs",
            new ModStairsBlock(ModBlocks.DARK_PURPUR.getDefaultState(),FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_SLAB = registerBlock("dark_purpur_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PECULIA);
    public static final Block DARK_PURPUR_WALL = registerBlock("dark_purpur_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).strength(2f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()), ModItemGroup.PECULIA);

    public static final Block VOID_LAMP = registerBlock("void_lamp",
            new VoidLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP, MapColor.PALE_PURPLE).sounds(BlockSoundGroup.GLASS).luminance(12).requiresTool().hardness(0.3f).strength(0.3f)), ModItemGroup.PECULIA);
    public static final Block CONDENSED_VOID = registerBlock("condensed_void",
            new CondensedVoidBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PURPLE).resistance(9999).hardness(9999).noCollision().luminance(12).dropsNothing()), ModItemGroup.PECULIA);



    public static final Block SILLTAR_FLUID_BLOCK = registerBlockWithoutBlockItem("silltar_fluid",
            new ModFluidBlock(ModFluids.SILLTAR_STILL, FabricBlockSettings.of(Material.WATER).nonOpaque().noCollision().dropsNothing()), ModItemGroup.PECULIA);



    public static final Block ERODED_END_STONE = registerBlock("eroded_end_stone",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).strength(1f)), ModItemGroup.PECULIA);
    public static final Block DRAGONGLASS = registerBlock("dragonglass",
    new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);
    public static final Block DRAGONGLASS_PANE = registerBlock("dragonglass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(1f).nonOpaque().requiresTool()), ModItemGroup.PECULIA);

    //oveer world
    public static final Block CRUMBLING_STONE = registerBlock("crumbling_stone", new CrumblingBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f).resistance(6)), ModItemGroup.PECULIA);
    public static final Block COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(6)), ModItemGroup.PECULIA);
    public static final Block CONTAINED_COBBLESTONE = registerBlock("contained_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(12)), ModItemGroup.PECULIA);
    public static final Block CONTINENTAL_COBBLESTONE = registerBlock("continental_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(18)), ModItemGroup.PECULIA);
    public static final Block ANOMALAIC_COBBLESTONE = registerBlock("anomalaic_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(24)), ModItemGroup.PECULIA);
    public static final Block AWAKENED_COBBLESTONE = registerBlock("awakened_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.5f).requiresTool().sounds(BlockSoundGroup.METAL).resistance(30)), ModItemGroup.PECULIA);




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
