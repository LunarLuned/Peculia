package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HealingTomeItem extends Item {


    public HealingTomeItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


        ItemStack itemStack;
            itemStack = user.getArrowType(ItemStack.EMPTY);
            if (!itemStack.isEmpty()) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(ModItems.SOUL);
                }
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
                user.getItemCooldownManager().set(this, 200);
                world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, SoundCategory.NEUTRAL, 1f, 1f);
                itemStack.decrement(1);
            }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
