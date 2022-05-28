package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.custom.ModAxeItem;
import net.lunarluned.peculia.item.custom.ModHoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item MYTHRIL_SHARD = registerItem("mythril_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_FRAGMENT = registerItem("mythril_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_CLAYMORE = registerItem("mythril_claymore",
            new SwordItem(ModToolMaterials.MYTHRIL,5, -3f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_SCYTHE = registerItem("mythril_scythe",
            new ModHoeItem(ModToolMaterials.MYTHRIL, 2, -2.7f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));
    public static final Item MYTHRIL_HALBERD = registerItem("mythril_halberd",
            new ModAxeItem(ModToolMaterials.MYTHRIL,7, -3.2f, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Peculia.MOD_ID, name), item);
    }

    public static void registerModItems() {
    Peculia.LOGGER.info("Registering mod items for " + Peculia.MOD_ID);
    }

}
