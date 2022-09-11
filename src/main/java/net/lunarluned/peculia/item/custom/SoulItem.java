package net.lunarluned.peculia.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulItem extends Item
{
    public SoulItem(Settings settings) {
        super(settings);
    }


    public void consumeSoul(ItemStack stack, PlayerEntity player) {
        stack.decrement(1);
        if (stack.isEmpty()) {
            player.getInventory().removeOne(stack);
        }
    }
}
