package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lunarluned.peculia.Peculia;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PECULIA = FabricItemGroupBuilder.build(new Identifier(Peculia.MOD_ID, "peculia"),
            () -> new ItemStack(ModItems.MYTHRIL_INGOT));
}
