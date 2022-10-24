package net.lunarluned.peculia.common.registry.entity.living_entities.ghost;

import net.lunarluned.peculia.common.registry.ModMobTypes;
import net.lunarluned.peculia.common.registry.entity.registry.ModEntities;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.modmats.ModArmorMaterials;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.Iterator;

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
            this.fallAnimationState.startIfStopped(this.tickCount);
        }
        else {
            super.handleEntityEvent(b);
        }
    }

    protected boolean isSunSensitive() {
        return true;
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
        if ((this.getHealth() < this.getMaxHealth() / 2) || this.isAngered()) {
            if (this.getRandom().nextInt(10) <= 10) {
                this.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false, false));
            }
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
        if (this.isAlive()) {
            boolean bl = this.isSunSensitive() && this.isSunBurnTick() && !this.isAngered();
            if (bl) {
                this.setAngered(true);
            }
            updateAngered(level);
        }
        if (this.level.isClientSide) {
            for(int i = 0; i < 2; ++i) {
                Vec3 vec3 = this.getDeltaMovement();
                this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX() + (this.random.nextDouble() - 0.5) * (double)this.getBbWidth(), this.getY() + 0.4, this.getZ() + (this.random.nextDouble() - 0.5) * (double)this.getBbWidth(), vec3.x * -0.2, 0.1, vec3.z * -0.2);
            }
        }
        super.aiStep();
    }

    //attributes

    public static AttributeSupplier.Builder createGhostAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 30.0).add(Attributes.MOVEMENT_SPEED, 0.25f).add(Attributes.ARMOR, 8.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.4).add(Attributes.ATTACK_DAMAGE, 8.0).add(Attributes.FOLLOW_RANGE, 8.0);
    }


    public MobType getMobType() {
        return ModMobTypes.GHOUL;
    }


    public boolean isAngered() {
        double d = this.getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aABB = AABB.unitCubeFromLowerCorner(this.position()).inflate(d, 20.0, d);
        this.level.getEntitiesOfClass(GhostEntity.class, aABB, EntitySelector.NO_SPECTATORS).stream().filter((ghost) -> {
            return ghost != this;
        }).filter((ghost) -> {
            return ghost.getTarget() == null;
        }).filter((ghost) -> {
            return !ghost.isAlliedTo(this.getTarget());
        }).forEach((ghost) -> {
            ghost.setTarget(this.getTarget());
        });
        return this.entityData.get(ANGERED);
    }
    public void setAngered(boolean isAngered) {
        this.entityData.set(ANGERED, isAngered);
        this.playSound(ModSoundEvents.ENTITY_GHOST_EMPOWERED, 1.0F, 1.0F);
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
        }

    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setAngered(nbt.getBoolean("IsAngered"));
    }

    // Prevents the Ghost from drowning

    protected int decreaseAirSupply(int i) {
        return i;
    }



    // Plays the animations upon ticking

    @Override
    public void tick() {
        if (!this.isOnGround() && !this.isAngered()) {
            this.attackAnimationState.stop();
            this.walkAnimationState.stop();
            this.idleAnimationState.stop();
            this.fallAnimationState.startIfStopped(this.tickCount);
            this.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 0, false, false, false));
        }
        if (this.isAngered()) {
            this.spawnSoulSpeedParticle();
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 0, false, false, false));
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 1, false, false, false));
        }
        LivingEntity livingEntity = this.getTarget();
        if (this.getHealth() < this.getMaxHealth() / 2) {
            if (this.getRandom().nextInt(1000) >= 1000) {
                this.playSound(ModSoundEvents.ENTITY_GHOST_EMPOWERED, 1.0F, 1.0F);
            }

                this.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 30, 3, false, false, false));

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