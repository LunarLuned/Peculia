package net.lunarluned.peculia.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lunarluned.peculia.Peculia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab PECULIA = FabricItemGroupBuilder.build(new ResourceLocation(Peculia.MOD_ID, "peculia"),
    () -> new ItemStack(ModItems.MYTHRIL_INGOT));

    public static final CreativeModeTab PECULIA_NETHER = FabricItemGroupBuilder.build(new ResourceLocation(Peculia.MOD_ID, "peculia_nether"),
    () -> new ItemStack(ModItems.ICHOR));

    public static final CreativeModeTab PECULIA_OVERWORLD = FabricItemGroupBuilder.build(new ResourceLocation(Peculia.MOD_ID, "peculia_overworld"),
    () -> new ItemStack(ModItems.DIAMOND_GAUNTLET));

    public static final CreativeModeTab PECULIA_ARCANE = FabricItemGroupBuilder.build(new ResourceLocation(Peculia.MOD_ID, "peculia_arcane"),
            () -> new ItemStack(ModItems.TOME_OF_HEALING));

    public static final CreativeModeTab PECULIA_MISC = FabricItemGroupBuilder.build(new ResourceLocation(Peculia.MOD_ID, "peculia_misc"),
    () -> new ItemStack(ModItems.FALLEN_HERO_DAGGER));
}
