package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.Peculia;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.AxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment THUNDERING = register("thundering",
            new ThunderingEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.TRIDENT));
    public static Enchantment ECHO = register("echo",
            new EchoEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON));
    public static Enchantment CONCUSS = register("concuss",
            new EchoEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.DIGGER));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Peculia.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantMents() {
        System.out.println("Registering enchantments for " + Peculia.MOD_ID);
    }
}
