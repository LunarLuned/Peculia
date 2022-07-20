package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EmptyArcaniumBottleItem extends Item {
    public EmptyArcaniumBottleItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (user.experienceLevel > 0) {
            user.addExperience(-7);
            user.giveItemStack(new ItemStack(Items.EXPERIENCE_BOTTLE, 1));
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        else {
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.BLOCK_CONDENSED_VOID_STEP, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
