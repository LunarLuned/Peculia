package net.lunarluned.peculia.entity.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.Level;

public class PeculiarSliceEntity extends AbstractHurtingProjectile {


    public PeculiarSliceEntity(EntityType<? extends AbstractHurtingProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {

    }
}
