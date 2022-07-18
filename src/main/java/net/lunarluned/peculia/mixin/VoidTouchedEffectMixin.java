package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class VoidTouchedEffectMixin extends Entity {

    public VoidTouchedEffectMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    @Nullable
    public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float multiplyDamageForVoidTouched(float amount) {
        if (this.hasStatusEffect(ModEffects.VOID_TOUCHED)) {
            return amount + (amount * (0.45f * (this.getStatusEffect(ModEffects.VOID_TOUCHED).getAmplifier() + 1)));
        }
        return amount;
    }

    @Inject(at = @At("HEAD"), method = "heal", cancellable = true)
    private void heal(CallbackInfo ci) {
        if(this.getStatusEffect(ModEffects.STAGNATED) != null) {
            ci.cancel();
        }
    }
}
