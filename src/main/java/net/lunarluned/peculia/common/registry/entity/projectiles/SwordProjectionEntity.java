package net.lunarluned.peculia.common.registry.entity.projectiles;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class SwordProjectionEntity extends AbstractArrow {
    public SwordProjectionEntity(EntityType<? extends SwordProjectionEntity> entityType, Level level) {
        super(entityType, level);
    }

    private boolean dealtDamage;



    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    Entity entity = this.getOwner();

    public void tick() {
        this.setNoPhysics(true);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 vec3, Vec3 vec32) {
        return this.dealtDamage ? null : super.findHitEntity(vec3, vec32);
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 11.0F;
        Entity entity2 = this.getOwner();
        DamageSource damageSource = DamageSource.mobAttack((LivingEntity) entity2);
        this.dealtDamage = true;
        if (entity.hurt(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity) entity;

                this.doPostHurtEffects(livingEntity2);
            }
        }
    }

    public void tickDespawn() {
        if (this.pickup != Pickup.ALLOWED ) {
            super.tickDespawn();
        }

    }


    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double d, double e, double f) {
        return true;
    }
}
