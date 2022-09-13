package net.lunarluned.peculia.item.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SoulItem extends Item
{
    public SoulItem(Item.Properties settings) {
        super(settings);
    }

    public void consumeSoul(ItemStack stack, Player player) {
        stack.shrink(1);
        if (stack.isEmpty()) {
            player.getInventory().removeItem(stack);
        }
    }
}
