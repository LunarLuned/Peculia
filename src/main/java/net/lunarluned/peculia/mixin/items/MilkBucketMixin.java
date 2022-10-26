package net.lunarluned.peculia.mixin.items;


import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.mixin.util.accessor.MobEffectInstanceAccessor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.MilkBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import java.util.ArrayList;
import java.util.List;

@Mixin(MilkBucketItem.class)
public class MilkBucketMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;removeAllEffects()Z"), method = "finishUsingItem")
    private boolean milkRework(LivingEntity livingEntity) {
        if (Peculia.getConfig().items.itemsConfig.itemChanges.milk_rework)  {
            List<MobEffectInstance> effects = new ArrayList<>(livingEntity.getActiveEffects());
            if (effects.isEmpty()) {
                return true;
            }
            MobEffectInstance effect = effects.get(livingEntity.level.random.nextInt(effects.size()));
            ((MobEffectInstanceAccessor) effect).setDuration((int) (effect.getDuration() * 0.8));
        } else {
            livingEntity.removeAllEffects();
        }
        return false;
    }
}
