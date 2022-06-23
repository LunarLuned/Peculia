package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.fluid.ModFluids;
import net.lunarluned.peculia.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //end
    public static final Item MYTHRIL_SHARD = registerItem("mythril_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_FRAGMENT = registerItem("mythril_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.PECULIA)));
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

    public static final Item SILLTAR_BUCKET = registerItem("silltar_bucket",
            new BucketItem(ModFluids.SILLTAR_STILL, new FabricItemSettings().group(ModItemGroup.PECULIA).maxCount(1)));



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

    //overworld
    public static final Item DIAMOND_GAUNTLET = registerItem("diamond_gauntlet",
            new ModGauntletItem(ToolMaterials.DIAMOND, 2, -2.2f, new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item IRON_GAUNTLET = registerItem("iron_gauntlet",
            new ModGauntletItem(ToolMaterials.IRON, 1, -2.3f, new FabricItemSettings().group(ModItemGroup.PECULIA)));
    public static final Item GOLDEN_GAUNTLET = registerItem("golden_gauntlet",
            new ModGauntletItem(ToolMaterials.GOLD, 1, -2.1f, new FabricItemSettings().group(ModItemGroup.PECULIA)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Peculia.MOD_ID, name), item);
    }

    public static void registerModItems() {
    Peculia.LOGGER.info("Registering mod items for " + Peculia.MOD_ID);
    }

}
