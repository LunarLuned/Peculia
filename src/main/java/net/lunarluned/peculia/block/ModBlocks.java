package net.lunarluned.peculia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.custom.ModStairsBlock;
import net.lunarluned.peculia.block.custom.MythrilCrystalBlock;

import net.lunarluned.peculia.item.ModItemGroup;
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

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block POPROCK_CRYSTAL = registerBlock("poprock_crystal",
            new Block(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(1f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_CRYSTAL = registerBlock("mythril_crystal",
            new MythrilCrystalBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER), UniformIntProvider.create(3, 8)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICKS = registerBlock("mythril_bricks",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_STAIRS = registerBlock("mythril_brick_stairs",
            new ModStairsBlock(ModBlocks.MYTHRIL_BRICKS.getDefaultState(),FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.LIGHT_BLUE_GRAY).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_SLAB = registerBlock("mythril_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.AMETHYST).mapColor(MapColor.LIGHT_BLUE_GRAY).strength(2f).nonOpaque().requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_BRICK_WALL = registerBlock("mythril_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.LIGHT_BLUE_GRAY).strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque()), ModItemGroup.PECULIA);

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

    public static void registerModBlocks() {
        Peculia.LOGGER.info("Registering mod blocks for " + Peculia.MOD_ID);
    }
}
