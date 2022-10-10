package net.lunarluned.peculia.mixin.entities;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract boolean hasEffect(MobEffect mobEffect);

    @Shadow @Nullable public abstract MobEffectInstance getEffect(MobEffect mobEffect);

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }


    @ModifyVariable(method = "hurt", at = @At("HEAD"), argsOnly = true)
    private float multiplyDamageForVoidTouched(float amount) {
        if (this.hasEffect(ModEffects.VOID_TOUCHED)) {
            return amount + (amount * (0.45f * (Objects.requireNonNull(this.getEffect(ModEffects.VOID_TOUCHED)).getAmplifier() + 1)));
        }
        if (this.hasEffect(ModEffects.POROUS)) {
            return amount + (amount * (0.65f * (Objects.requireNonNull(this.getEffect(ModEffects.POROUS)).getAmplifier() + 5)));
        }
        if (this.hasEffect(ModEffects.DETERMINED)) {
            return amount + (amount * (-0.20f * (Objects.requireNonNull(this.getEffect(ModEffects.DETERMINED)).getAmplifier() + 1)));
        }
        return amount;
    }

    @Inject(at = @At("HEAD"), method = "heal", cancellable = true)
    private void heal(CallbackInfo ci) {
        if(this.getEffect(ModEffects.STAGNATED) != null) {
            ci.cancel();
        }
    }
}
