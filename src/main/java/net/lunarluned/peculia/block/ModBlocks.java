package net.lunarluned.peculia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.block.custom.MythrilCrystalBlock;
import net.lunarluned.peculia.block.custom.PointedMythrilBlock;
import net.lunarluned.peculia.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block MYHTRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block MYTHRIL_CRYSTAL = registerBlock("mythril_crystal",
            new MythrilCrystalBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER)), ModItemGroup.PECULIA);
    public static final Block POINTED_MYTHRIL = registerBlock("pointed_mythril",
            new PointedMythrilBlock(FabricBlockSettings.of(Material.AMETHYST).nonOpaque().strength(2f).requiresTool()), ModItemGroup.PECULIA);
    public static final Block COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block CONTAINED_COBBLESTONE = registerBlock("contained_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block CONTINENTAL_COBBLESTONE = registerBlock("continental_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block ANOMALAIC_COBBLESTONE = registerBlock("anomalaic_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);
    public static final Block AWAKENED_COBBLESTONE = registerBlock("awakened_cobblestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.5f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.PECULIA);

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
