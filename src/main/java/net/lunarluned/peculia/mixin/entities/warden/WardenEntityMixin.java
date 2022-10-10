package net.lunarluned.peculia.mixin.entities.warden;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Warden.class)
public abstract class WardenEntityMixin extends Monster {

    protected WardenEntityMixin(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    // Increases the Warden's health from 500 to 1000

    @Inject(at = @At("HEAD"), method = "createAttributes", cancellable = true)
    private static void createAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        if (Peculia.getConfig().mobs.vanillaMobsConfig.wardenConfig.stat_increase) {
            cir.setReturnValue(Monster.createMonsterAttributes()
                    .add(Attributes.MAX_HEALTH, 1000.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                    .add(Attributes.ATTACK_SPEED, 5)
                    .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                    .add(Attributes.ATTACK_DAMAGE, 30.0D)
                    .add(Attributes.ARMOR, 10.0D));
        }
    }

    @Inject(at = @At("RETURN"), method = "doHurtTarget", cancellable = true)
    public void doHurtTarget(Entity entity, CallbackInfoReturnable<Boolean> cir) {

        if (entity instanceof LivingEntity) {
            if (Peculia.getConfig().mobs.vanillaMobsConfig.wardenConfig.cursed_on_hit) {

                // Adds a status effect when an entity is hit by the Warden

                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.CURSED, 40, 0, false, true, true));
            }
        }
        cir.setReturnValue(super.doHurtTarget(entity));
    }
}
