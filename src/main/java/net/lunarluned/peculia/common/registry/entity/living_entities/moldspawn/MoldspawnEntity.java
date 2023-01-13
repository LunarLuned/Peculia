package net.lunarluned.peculia.common.registry.entity.living_entities.moldspawn;


import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.PeculiaTags;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MoldspawnEntity extends Monster {

    public int moldshedtick;

    public MoldspawnEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.moldshedtick = this.random.nextInt(3000) + 1700;

        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0f);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.TRAPDOOR, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.DANGER_CACTUS, 8.0f);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_CACTUS, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, -1.0f);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

    public static boolean checkMoldspawnSpawnRules(ServerLevelAccessor serverLevelAccessor, BlockPos blockPos) {
        return serverLevelAccessor.getBlockState(blockPos.below()).is(PeculiaTags.MOLDSPAWN_SPAWNABLE_ON);
    }

    // Attributes

    public static AttributeSupplier.Builder createMoldspawnAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 12.0).add(Attributes.MOVEMENT_SPEED, 0.35f).add(Attributes.ATTACK_DAMAGE, 8.0).add(Attributes.FOLLOW_RANGE, 14.0);
    }

    // Moldspawn Animation States

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState leapAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState biteAnimationState = new AnimationState();

    private boolean isMoving() {
        return this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;
    }

    // Placeholder goals, will eventually be replaced with a brain

    public void registerGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true));
    }

    public boolean canAttackType(@NotNull EntityType<?> entityType) {
        return (!entityType.is(PeculiaTags.MOLDS_CANNOT_ATTACK));
    }

    public float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public void handleEntityEvent(byte b) {
        if (b == 4) {
            this.idleAnimationState.stop();
            this.biteAnimationState.start(this.tickCount);
        }
        else {
            super.handleEntityEvent(b);
        }
    }

    public boolean isSuspicious() {
        return (("Sus".equals(ChatFormatting.stripFormatting(this.getName().getString()))) || ("Sydokiddo".equals(ChatFormatting.stripFormatting(this.getName().getString()))));
    }

    public boolean removeWhenFarAway(double distanceSquared) {
        return !this.isPersistenceRequired();
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.ENTITY_MOLDSPAWN_IDLE;
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSoundEvents.ENTITY_MOLDSPAWN_HURT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ENTITY_MOLDSPAWN_DEATH;
    }

    @Override
    protected void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15f, 1.0f);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean bl = super.doHurtTarget(entity);
        if (bl) {
            this.biteAnimationState.start(this.tickCount);
            this.level.broadcastEntityEvent(this, (byte)4);
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if (this.random.nextFloat() < f * 0.3F) {
                assert entity instanceof LivingEntity;
                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffects.ICHOR, 90, 0, false, true, true));
            }
        }

        return bl;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && this.isInLava() && this.isAlive() && !this.isBaby() && --this.moldshedtick <= 0) {
            //placeholder sound
            this.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ModItems.MOLDMEIN);
            this.moldshedtick = this.random.nextInt(3000) + 3000;
        }
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("MoldShedTick")) {
            this.moldshedtick = compoundTag.getInt("MoldShedTick");
        }
    }
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("MoldShedTick", this.moldshedtick);
    }


    @Override
    public void tick() {
        // Moldspawn Animations
        if (this.level.isClientSide()) {
            this.level.broadcastEntityEvent(this, (byte)1);

            if (this.isMoving()) {
                this.idleAnimationState.stop();
                this.walkAnimationState.startIfStopped(this.tickCount);
            } else {
                this.walkAnimationState.stop();
                this.idleAnimationState.startIfStopped(this.tickCount);
            }
        }
        super.tick();
    }
}
