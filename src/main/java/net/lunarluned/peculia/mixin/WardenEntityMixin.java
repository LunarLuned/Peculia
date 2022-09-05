package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WardenEntity.class)
public abstract class WardenEntityMixin extends HostileEntity {

    protected WardenEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    // Increases the Warden's health from 500 to 1000

    @Inject(at = @At("HEAD"), method = "addAttributes", cancellable = true)
    private static void addAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {

        cir.setReturnValue(HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000.0D)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D)
                        .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5)
        .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.0D).add(EntityAttributes.GENERIC_ARMOR, 10.0D));

    }

    @Inject(at = @At("HEAD"), method = "tryAttack", cancellable = true)
    public void tryAttack(Entity target, CallbackInfoReturnable<Boolean> cir) {

        this.world.sendEntityStatus(this, (byte)4);
        this.playSound(SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, 10.0F, this.getSoundPitch());
        SonicBoomTask.cooldown(this, 40);

        if (target instanceof LivingEntity) {

            // Adds a status effect when an entity is hit by the Warden

            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.CURSED, 120, 0, false, true, true));

        }
        cir.setReturnValue(super.tryAttack(target));
    }
}
