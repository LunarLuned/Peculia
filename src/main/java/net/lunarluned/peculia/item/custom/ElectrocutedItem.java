package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class ElectrocutedItem extends ModDaggerItem {
    public ElectrocutedItem(Tier toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        super.hurtEnemy(stack, target, attacker);
        if (attacker.getRandom().nextInt(100) <= Peculia.getConfig().items.itemsConfig.itemChances.charged_chance) {
            target.addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 60, 0));
            attacker.level.playSound(null, target.getOnPos(), ModSoundEvents.DAGGER_CHARGE, SoundSource.PLAYERS, 1.0f, 0.8f + attacker.level.random.nextFloat() * 0.4F);
        }
        return true;
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
