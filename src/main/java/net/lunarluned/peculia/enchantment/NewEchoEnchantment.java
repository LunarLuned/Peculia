package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.item.custom.ModSwordItem;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;

import java.util.Collection;

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
            player.world.playSound(null, player.getBlockPos(), ModSoundEvents.ECHO_ATTACK_HIT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            ItemStack item = player.getStackInHand(Hand.MAIN_HAND);
            EquipmentSlot hand = EquipmentSlot.MAINHAND;
            //target.damage(DamageSource.GENERIC, item.getAttributeModifiers(hand).get(getAttackDamage()));
        }
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.SHARPNESS;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModSwordItem;
    }
    }