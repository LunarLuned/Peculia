package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.BlockTags;

public class PeculiarDaggerItem extends ModDaggerItem {


    public PeculiarDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(Items.NETHERITE_SCRAP).test(ingredient) || super.canRepair(stack, ingredient);
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 25.0F;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHit(stack, target, attacker);
        target.addStatusEffect(new StatusEffectInstance(ModEffects.LUNAR_SICKNESS, 80, 0));
        return true;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }


}
