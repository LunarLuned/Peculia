package net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode;

import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.UUID;

public class CoalGeodeEntity extends AbstractGolem implements NeutralMob {



    public void registerGoals() {
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[0])));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
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
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, 0.4000000059604645 * e, 0.0));
            this.doEnchantDamageEffects(this, entity);
        }

        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return bl;
    }

    public boolean canAttackType(EntityType<?> entityType) {
            return entityType != EntityType.CREEPER && super.canAttackType(entityType);
        }


    protected static final ImmutableList<SensorType<? extends Sensor<? super CoalGeodeEntity>>> SENSOR_TYPES =
            ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS);


    public static final Ingredient TEMPTATION_ITEM = Ingredient.of(Items.STONE);

    public CoalGeodeEntity(EntityType<? extends AbstractGolem> entityType, Level level) {
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
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState spitAnimationState = new AnimationState();
    public final AnimationState feedingAnimationState = new AnimationState();

    public void aiStep() {
        super.aiStep();
        if (this.isLeashed()) {
            this.setPersistenceRequired();
        }
    }
    //attributes

    public static AttributeSupplier.Builder createCoalGeodeAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 16.0).add(Attributes.MOVEMENT_SPEED, 0.28f).add(Attributes.ARMOR, 8.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.6).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.FOLLOW_RANGE, 48.0);
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
        super.defineSynchedData();
    }

    // Prevents the Coal Geode from drowning, similar to Iron Golems

    protected int decreaseAirSupply(int i) {
        return i;
    }

    // Plays the animations upon ticking

    @Override
    public void tick() {
        if (this.level.isClientSide()) {

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

    // Interacting with Coal Geode with Stone

    public boolean isFood(@NotNull ItemStack itemStack) {
        return TEMPTATION_ITEM.test(itemStack);
    }

    private void usePlayerItem(Player player, @NotNull InteractionHand interactionHand, ItemStack itemStack) {
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
    }

    public InteractionResult mobInteract(Player player, @NotNull InteractionHand interactionHand) {

        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (this.isFood(itemStack)) {

            if (!this.level.isClientSide) {
                this.usePlayerItem(player, interactionHand, itemStack);
                this.gameEvent(GameEvent.EAT, this);
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, true, true));
                this.setPersistenceRequired();

                // Eating Sound

                if (!this.isSilent()) {
                    this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.STONE_BREAK, this.getSoundSource(), 1.0f, 1.0f + (this.random.nextFloat() - this.random.nextFloat()) * 0.2f);
                }

                return InteractionResult.SUCCESS;

            }
            if (this.level.isClientSide) {
                return InteractionResult.CONSUME;
            }
        }
        return super.mobInteract(player, interactionHand);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    public boolean removeWhenFarAway(double distanceSquared) {
        return !this.isPersistenceRequired();
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int i) {

    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID uUID) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }
}
