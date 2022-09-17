package net.lunarluned.peculia.item.compat;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.modmats.ModToolMaterials;
import net.lunarluned.peculia.item.custom.ModSwordItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class CombatantItems {

    @SuppressWarnings("ALL")

    // List of Items:

    public static final Item MYTHRIL_SICKLE = registerItem(
            new ModSwordItem((Tier) ModToolMaterials.MYTHRIL, (int) 1.5f, -2f,
                    new FabricItemSettings().tab(CreativeModeTab.TAB_COMBAT)));

    private static Item registerItem(Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(Peculia.MOD_ID, "mythril_sickle"), item);
    }

    public static void registerCombatantCompatItems() {
        System.out.println("Registering Combatant Compatibility Items for " + Peculia.MOD_ID);
    }
}
