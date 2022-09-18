package net.lunarluned.peculia.mixin.effects.anchored;

import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownEnderpearl.class)
public abstract class EnderPearlMixin extends ThrowableItemProjectile {

    public EnderPearlMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    Entity entity = this.getOwner();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/ThrownEnderpearl;getOwner()Lnet/minecraft/world/entity/Entity;"), method = "tick", cancellable = true)
    public void cancelTeleportation(CallbackInfo ci) {
        if (entity instanceof ServerPlayer && ((ServerPlayer) entity).hasEffect(ModEffects.ANCHORED)) {
            this.discard();
            entity.gameEvent(GameEvent.ITEM_INTERACT_START);
            this.level.playSound(null, this.getX(), this.getY(), this.getZ(), ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, this.getSoundSource(), 1.0f, 1.0f);
            if (this.random.nextFloat() < 0.9F && this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                Endermite endermite = EntityType.ENDERMITE.create(this.level);
                assert endermite != null;
                endermite.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                this.level.addFreshEntity(endermite);
            }
            ci.cancel();
        }
    }
}
