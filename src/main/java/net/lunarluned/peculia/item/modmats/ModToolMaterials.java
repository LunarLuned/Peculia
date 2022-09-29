package net.lunarluned.peculia.item.modmats;

import net.lunarluned.peculia.item.ModItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements Tier {

    MYTHRIL(4, 1967, 10.0F, 3.0F, 20, () -> {
        return Ingredient.of(ModItems.MYTHRIL_INGOT);
    }),
    SHARD(4, 1469, 9.0F, 2.0F, 1, () -> {
        return Ingredient.of(ModItems.MYTHRIL_FRAGMENT);
    }),
    COPPER(4, 456, 9.0F, 2.0F, 1, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    }),
    PECULIAR(6, 2452, 13.0F, 5.0F, 25, () -> {
        return Ingredient.of(ModItems.BOTTLE_OF_CONDENSED_VOID);
    }),
    SCYTHE(6, 950, 0F, 0.0F, 1, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    }),
    SCRAP(4, 890, 9.0F, 4.0F, 1, () -> {
        return Ingredient.of(Items.NETHERITE_SCRAP);

    });



    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new LazyLoadedValue(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.itemDurability;
    }

    @Override
    public float getSpeed() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}

