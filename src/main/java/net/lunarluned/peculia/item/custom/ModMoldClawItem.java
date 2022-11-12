package net.lunarluned.peculia.item.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class ModMoldClawItem extends ModGauntletItem {

    public ModMoldClawItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        super.hurtEnemy(stack, target, attacker);
        if (attacker.getRandom().nextInt(100) <= Peculia.getConfig().items.itemsConfig.itemChances.moldclaw_ichor_dipped_chance)
        {
            target.addEffect(new MobEffectInstance(ModEffects.ICHOR, 40, 0));
        }
        return true;
    }

}
