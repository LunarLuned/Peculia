package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.config.ModConfig;
import net.lunarluned.peculia.config.options.items.ItemChances;
import net.lunarluned.peculia.config.options.items.ItemsConfig;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class PeculiarDaggerItem extends ModDaggerItem {


    public PeculiarDaggerItem(Tier toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(Items.NETHERITE_SCRAP);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (attacker instanceof Player player && player.getRandom().nextInt(100) <= Peculia.getConfig().items.itemsConfig.itemChances.echoing_chance) {
            player.level.playSound(null, player.getOnPos(), ModSoundEvents.ECHO_ATTACK_HIT, SoundSource.PLAYERS, 1.0F, 1.0F);
            super.hurtEnemy(stack, target, attacker);
            target.addEffect(new MobEffectInstance(ModEffects.ECHOING, 40, 0));
            return true;
        }
        return true;
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack item) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }
}
