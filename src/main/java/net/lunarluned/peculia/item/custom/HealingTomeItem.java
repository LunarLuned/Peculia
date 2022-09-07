package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealingTomeItem extends Item {


    public HealingTomeItem(Settings settings) {
        super(settings);
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


        ItemStack itemStack = user.getActiveItem();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
            user.getItemCooldownManager().set(this, 200);
            world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, SoundCategory.NEUTRAL, 1f, 1f);
            return TypedActionResult.success(itemStack, world.isClient());
    }
    }
