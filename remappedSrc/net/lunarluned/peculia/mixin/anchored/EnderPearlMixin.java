package net.lunarluned.peculia.mixin.effects.anchored;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(EnderPearlEntity.class)
public abstract class EnderPearlMixin extends ThrownItemEntity {
    public EnderPearlMixin(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    @Shadow
    @Nullable
    public abstract Entity moveToWorld(ServerWorld destination);
    Entity entity = this.getOwner();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/thrown/EnderPearlEntity;getOwner()Lnet/minecraft/entity/Entity;"), method = "tick", cancellable = true)
    public void cancelTeleportation(CallbackInfo ci) {
        if (entity instanceof ServerPlayerEntity && ((ServerPlayerEntity) entity).hasStatusEffect(ModEffects.ANCHORED)) {
            this.discard();
            entity.emitGameEvent(GameEvent.ITEM_INTERACT_START);
            this.world.playSound(null, this.getX(), this.getY(), this.getZ(), ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, this.getSoundCategory(), 1.0f, 1.0f);
            if (this.random.nextFloat() < 0.9F && this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                EndermiteEntity endermiteEntity = EntityType.ENDERMITE.create(this.world);
                assert endermiteEntity != null;
                endermiteEntity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());
                this.world.spawnEntity(endermiteEntity);
            }
            ci.cancel();
        }
    }
}
