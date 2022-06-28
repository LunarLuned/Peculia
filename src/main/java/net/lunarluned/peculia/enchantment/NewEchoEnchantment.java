package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.item.custom.ModSwordItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;

public class NewEchoEnchantment extends Enchantment {
    public NewEchoEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (user instanceof PlayerEntity player && player.getRandom().nextInt(100) <= PeculiaConfig.getIntValue("echo_chance")) {
                target.damage(DamageSource.player(player), player.getStackInHand(Hand.MAIN_HAND).getDamage());
                player.world.playSound(null, player.getBlockPos(), ModSoundEvents.ECHO_ATTACK_HIT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                // AAAAAAAAAAAAAAAAAAAAAAAAAAA I FUCKING HATE THIS STUPID FUCKING GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
                // im gonna deal with this tomorrow fuck this stupid ass enchantment. kill yourself echo
                // its the fucking target.damage, but i have no clue how else to do this. no fucking idea. ill deal with it tmrw
                // THE WORST PART IS???? IT WAS WORKING???? WHAT MADE IT SUDDENLY NOT?????? ? ?? ?? ?? ?>????
            }
        super.onTargetDamaged(user, target, level);
    }



    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.SHARPNESS;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModSwordItem;
    }
    }