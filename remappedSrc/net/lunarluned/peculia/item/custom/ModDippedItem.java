package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModDippedItem extends ModDaggerItem {
    public ModDippedItem(Tier toolMaterial, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        super.hurtEnemy(stack, target, attacker);
        target.addEffect(new MobEffectInstance(ModEffects.ICHOR, 40, 0));
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
