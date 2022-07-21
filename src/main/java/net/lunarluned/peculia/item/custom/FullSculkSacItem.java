package net.lunarluned.peculia.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FullSculkSacItem extends Item {
    public FullSculkSacItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.addExperience(7);
        itemStack.decrement(1);
        user.emitGameEvent(GameEvent.BLOCK_PLACE);
        world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, SoundEvents.BLOCK_SCULK_CHARGE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
