package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.common.registry.entity.projectiles.SwordProjectionEntity;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PeculiarSwordItem extends ModDaggerItem {



    public PeculiarSwordItem(Tier toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    /*
    will work on this later. tired

    public int getUseDuration(ItemStack itemStack) {
        return 720;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemStack);
        } else {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemStack);
        }
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
        SwordProjectionEntity swordProjection = new SwordProjectionEntity(null, level);
        swordProjection.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 0.0F, 2.5F * 0.5F, 1.0F);
        level.addFreshEntity(swordProjection);
    }

     */

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(Items.NETHERITE_SCRAP);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
            attacker.level.playSound(null, attacker.getOnPos(), ModSoundEvents.ECHO_ATTACK_HIT, SoundSource.PLAYERS, 1.0F, 1.0F);
            super.hurtEnemy(stack, target, attacker);
            target.addEffect(new MobEffectInstance(ModEffects.ECHOING, 40, 0));
        return true;
    }
}
