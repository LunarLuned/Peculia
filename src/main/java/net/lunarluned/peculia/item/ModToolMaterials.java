package net.lunarluned.peculia.item;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    MYTHRIL(4, 1967, 10.0F, 3.0F, 20, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{ModItems.MYTHRIL_INGOT});
    }),
    SHARD(4, 1469, 9.0F, 2.0F, 1, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{ModItems.MYTHRIL_FRAGMENT});
    }),
    COPPER(4, 456, 9.0F, 2.0F, 1, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.COPPER_INGOT});
    }),
    PECULIAR(6, 2452, 13.0F, 5.0F, 25, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.COPPER_INGOT});
    }),
    SCRAP(4, 890, 9.0F, 4.0F, 1, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_SCRAP});

    });


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}

