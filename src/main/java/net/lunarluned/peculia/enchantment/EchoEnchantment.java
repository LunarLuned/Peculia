package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EchoEnchantment extends Enchantment {
    public EchoEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            if (user.isOnGround()) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.ECHO, 20 * 2 * level, level - 1));
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return 1.0F + (float)Math.max(0, level - 1) * -0.5F;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
