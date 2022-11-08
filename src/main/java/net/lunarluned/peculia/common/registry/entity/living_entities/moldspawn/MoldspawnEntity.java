package net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class MoldspawnEntity extends Monster {
    public MoldspawnEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    // Attributes

    public static AttributeSupplier.Builder createMoldspawnAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 10.0).add(Attributes.MOVEMENT_SPEED, 0.35f).add(Attributes.ATTACK_DAMAGE, 8.0).add(Attributes.FOLLOW_RANGE, 14.0);
    }
}
