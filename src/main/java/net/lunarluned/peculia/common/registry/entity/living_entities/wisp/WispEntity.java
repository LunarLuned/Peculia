package net.lunarluned.peculia.common.registry.entity.living_entities.wisp;

import net.lunarluned.peculia.common.registry.ModMobTypes;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.PeculiaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.NotNull;

public class WispEntity extends AbstractGolem {

    public void registerGoals() {
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.9));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
    }

    public static boolean checkWispSpawnRules(ServerLevelAccessor serverLevelAccessor, BlockPos blockPos) {
        return serverLevelAccessor.getBlockState(blockPos.below()).is(PeculiaTags.WISP_SPAWNABLE_ON);
    }

    public float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean doHurtTarget(Entity entity) {
        this.level.broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float g = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean bl = entity.hurt(DamageSource.mobAttack(this), g);
        if (bl) {
            double var10000;
            if (entity instanceof LivingEntity livingEntity) {
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

    public boolean hurt(DamageSource damageSource, float f) {
        Entity entity;
        entity = damageSource.getDirectEntity();
        if (entity instanceof SpectralArrow) {
            return super.hurt(damageSource, f * 1.35f);
        }
        return super.hurt(damageSource, f);
    }

    public static final Ingredient TEMPTATION_ITEM = Ingredient.of(ModItems.SOUL);

    public WispEntity(EntityType<? extends AbstractGolem> entityType, Level level) {
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
    public final AnimationState danceAnimationState = new AnimationState();

    public void aiStep() {
        super.aiStep();
        if (this.isLeashed()) {
            this.setPersistenceRequired();
        }
    }
    //attributes

    public static AttributeSupplier.Builder createWispAttributes() {
        return createMobAttributes().add(Attributes.MAX_HEALTH, 16.0).add(Attributes.MOVEMENT_SPEED, 0.28f).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.FOLLOW_RANGE, 48.0);
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
            // On Half Health, become determined function
            if (this.getHealth() < this.getMaxHealth() / 2) {

                this.addEffect(new MobEffectInstance(ModEffects.DETERMINED, 30, 3));
            }
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

    public MobType getMobType() {
        return ModMobTypes.GHOUL;
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

    /*/ disabling for now
    // Interacting with Wisp with Ectoplasm

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
                this.gameEvent(GameEvent.EAT, this);
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, true, true));
                this.setPersistenceRequired();

                // Eating Sound

                if (!this.isSilent()) {
                    this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.STONE_BREAK, this.getSoundSource(), 1.0f, 1.0f + (this.random.nextFloat() - this.random.nextFloat()) * 0.2f);
                }

                return soulDuplication(player, interactionHand);

            }
                return super.mobInteract(player, interactionHand);
        }
        return super.mobInteract(player, interactionHand);
    }

    public InteractionResult soulDuplication(Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!this.level.isClientSide) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            ItemStack soul = new ItemStack(ModItems.SOUL);
            if (!player.getInventory().contains(soul)) {
                player.drop(soul, false);
            } else {
                itemStack.setCount(itemStack.getCount() + 1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }
/*/
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    public boolean removeWhenFarAway(double distanceSquared) {
        return !this.isPersistenceRequired();
    }


}
