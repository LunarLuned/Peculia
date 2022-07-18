package net.lunarluned.peculia.enchantment;

import net.lunarluned.peculia.item.custom.ModHoeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class SwirlingEnchantment extends Enchantment {
    protected SwirlingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        //check that enchant is not in offhand
        if(EnchantmentHelper.getLevel(ModEnchantments.SWIRLING, user.getMainHandStack()) == 0|| target.distanceTo(user) >= 6)
            return;

        List<LivingEntity> list = target.world.getNonSpectatingEntities(LivingEntity.class, target.getBoundingBox().expand(3.0D, 0.25D, 3.0D));
        boolean bl = false;
        for (LivingEntity e : list) {
            if (!e.equals(user) && !e.equals(target)) {
                bl = true;
                e.takeKnockback(1, target.getX() - e.getX(), target.getZ() - e.getZ());
            }
        }

        if (bl && target.world instanceof ServerWorld) {
            for (double x = -6; x <= 6; x = x + 1) {
                double y = Math.sqrt(36 - x * x);
                ((ServerWorld) target.world).spawnParticles(ParticleTypes.SWEEP_ATTACK, target.getX() + x, target.getBodyY(0.5D), target.getZ() + y, 0, 1, 0.0D, 1, 0.0D);
                ((ServerWorld) target.world).spawnParticles(ParticleTypes.SWEEP_ATTACK, target.getX() + x, target.getBodyY(0.5D), target.getZ() - y, 0, 1, 0.0D, 1, 0.0D);
            }
        }
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ModHoeItem;
    }
}
