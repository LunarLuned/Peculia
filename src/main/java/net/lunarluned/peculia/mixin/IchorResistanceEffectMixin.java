package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class IchorResistanceEffectMixin extends Entity {

    public IchorResistanceEffectMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public abstract boolean hasEffect(MobEffect mobEffect);

    @Shadow
    public abstract boolean removeEffect(MobEffect mobEffect);

    @Inject(method = "tickEffects", at = @At(value = "HEAD"))
    public void tickEffects(CallbackInfo ci) {
        if (this.hasEffect(ModEffects.ICHOR_RESISTANCE)) {
            this.removeEffect(ModEffects.ICHOR);
        }
    }
}
