package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.custom.ModGauntletItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.AxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment THUNDERING = register("thundering",
            new ThunderingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.TRIDENT));
    public static Enchantment ECHO = register("echo",
            new EchoEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON));
    public static Enchantment CONCUSS = register("concuss",
            new ConcussEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.DIGGER));
    public static Enchantment PANICKED = register("panicked",
            new PanickedEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST));
    public static Enchantment MOMENTUM = register("momentum",
            new PanickedEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_LEGS));
    public static Enchantment SHORYUKEN = register("shoryuken",
            new ShoryukenEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.FISHING_ROD));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Peculia.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering enchantments for " + Peculia.MOD_ID);
    }
}
