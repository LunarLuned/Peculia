package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.Peculia;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ModEnchantments {
    public static Enchantment THUNDERING = register("thundering",
    new ThunderingEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.TRIDENT));

    // public static Enchantment ECHO = register("echo",
    // new NewEchoEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON));

    public static Enchantment CONCUSS = register("concuss",
    new ConcussEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER));

    public static Enchantment DETERMINED = register("determined",
    new DeterminedEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST));

    public static Enchantment BLESSED = register("blessed",
    new BlessedEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON));

    public static Enchantment SHORYUKEN = register("shoryuken",
    new ShoryukenEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.FISHING_ROD));

    public static Enchantment LEECHING = register("leeching",
    new LeechingEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.FISHING_ROD));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new ResourceLocation(Peculia.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering enchantments for " + Peculia.MOD_ID);
    }
}
