package net.lunarluned.peculia.item.compat;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.modmats.ModArmorMaterials;
import net.lunarluned.peculia.item.ModItemGroup;
import net.lunarluned.peculia.item.modmats.OdysseyArmorMaterials;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class OdysseyItems {

    @SuppressWarnings("ALL")

    // List of Items:

    public static final Item WITHER_SKULL_MASK = registerItem("wither_skull_mask",
            new ArmorItem(OdysseyArmorMaterials.WITHER_SKULL_MASK, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.PECULIA_MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(Peculia.MOD_ID, name), item);
    }


    public static void registerOdysseyCompatItems() {
        System.out.println("Registering Odyssey Compatibility Items for " + Peculia.MOD_ID);
    }
}
