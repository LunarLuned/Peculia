package net.lunarluned.peculia.common.registry.entity.living_entities.ghost;

import net.lunarluned.peculia.common.registry.ModMobTypes;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

public class GhostEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ANGERED = SynchedEntityData.defineId(GhostEntity.class, EntityDataSerializers.BOOLEAN);



    public void registerGoals() {
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, true));
    }

    public boolean canAttackType(EntityType<?> entityType) {
        return entityType != ModEntities.GHOST && entityType != ModEntities.WISP && entityType != EntityType.IRON_GOLEM && entityType != EntityType.ZOMBIE && entityType != EntityType.ZOMBIFIED_PIGLIN && entityType != EntityType.SKELETON && entityType != EntityType.CREEPER && super.canAttackType(entityType);
    }

    public void handleEntityEvent(byte b) {
        if (b == 4) {
            this.idleAnimationState.stop();
            this.attackAnimationState.start(this.tickCount);
        }
        if (b == 6) {
            this.attackAnimationState.stop();
            this.walkAnimationState.stop();
            this.idleAnimationState.stop();
            this.fallAnimationState.start(this.tickCount);
        }
        if (b == 5) {
            this.playSound(ModSoundEvents.ENTITY_GHOST_EMPOWERED, 1.0F, 1.0F);
        }
        else {
            super.handleEntityEvent(b);
        }
    }


    public SoundEvent getAmbientSound() {
        return ModSoundEvents.ENTITY_GHOST_MOAN;
    }

    public SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSoundEvents.ENTITY_GHOST_HURT;
    }

    public SoundEvent getDeathSound() {
        return ModSoundEvents.ENTITY_GHOST_DEATH;
    }

    public float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationState.start(this.tickCount);
        this.level.broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float g = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean bl = entity.hurt(DamageSource.mobAttack(this), g);
        if (bl) {
            double var10000;
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                var10000 = livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            } else {
                var10000 = 0.0;
            }

            double d = var10000;
            double e = Math.max(0.0, 1.0 - d);
            this.doEnchantDamageEffects(this, entity);
        }
        ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.CURSED, 80, 0, false, true, true));

        //this is the attack sound. its wrong rn but
        this.playSound(ModSoundEvents.ENTITY_GHOST_JUMPSCARE, 1.0F, 1.0F);
        return bl;
    }



    protected static final ImmutableList<SensorType<? extends Sensor<? super GhostEntity>>> SENSOR_TYPES =
            ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS);


    public GhostEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        if (this.getHealth() < this.getMaxHealth() / 2) {

            this.playSound(ModSoundEvents.ENTITY_GHOST_EMPOWERED, 1.0F, 1.0F);
        }
        this.lookControl = new LookControl(this);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0f);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0f);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.TRAPDOOR, -1.0f);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState fallAnimationState = new AnimationState();
    public final AnimationState hurtAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    public void aiStep() {
        super.aiStep();
    }
    //attributes

    public static AttributeSupplier.Builder createGhostAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 30.0).add(Attributes.MOVEMENT_SPEED, 0.25f).add(Attributes.ARMOR, 8.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.4).add(Attributes.ATTACK_DAMAGE, 8.0).add(Attributes.FOLLOW_RANGE, 8.0);
    }


    public MobType getMobType() {
        return ModMobTypes.GHOUL;
    }



    private boolean isMoving() {
        return this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;
    }
    @Override
    public boolean canBeLeashed(@NotNull Player player) {
        return !this.isLeashed();
    }
    @Override
    protected void defineSynchedData() {
        this.entityData.define(ANGERED, false);
        super.defineSynchedData();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("IsAngered", this.isAngered());
    }

    private void updateAngered(Level level) {
        if (!level.isClientSide()) {
            LivingEntity livingEntity = this.getTarget();
            if (livingEntity != null) {
                this.isAngered();
            }
        }

    }

    public boolean isAngered() {
        return this.entityData.get(ANGERED);
    }

    // Prevents the Ghost from drowning

    protected int decreaseAirSupply(int i) {
        return i;
    }

    // Plays the animations upon ticking



    @Override
    public void tick() {
        updateAngered(this.level);
        if (!this.isOnGround() && fallDistance > 1) {
            this.level.broadcastEntityEvent(this, (byte)6);
            this.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 0, false, false, false));
        }
        LivingEntity livingEntity = this.getTarget();
        if (this.getHealth() < this.getMaxHealth() / 2) {

            this.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 30, 3, false, false, false));
            this.level.broadcastEntityEvent(this, (byte)5);
        }

            if (this.isMoving()) {
                this.idleAnimationState.stop();
                this.fallAnimationState.stop();
                this.walkAnimationState.startIfStopped(this.tickCount);
            } else {
                this.walkAnimationState.stop();
                this.fallAnimationState.stop();
                this.idleAnimationState.startIfStopped(this.tickCount);
            }
        super.tick();
    }

    private boolean isInPose(Pose pose) {
        return this.getPose() == pose;
    }

    @Override
    public int getHeadRotSpeed() {
        return 10;
    }

    @Override
    public int getMaxHeadYRot() {
        return 20;
    }

    public boolean isPreventingPlayerRest(Player player) {
        return true;
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    public boolean removeWhenFarAway(double distanceSquared) {
        return !this.isPersistenceRequired();
    }

}