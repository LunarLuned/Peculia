package net.lunarluned.peculia.mixin.items;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {
    @Redirect(method = "finishUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;clearStatusEffects()Z"))
    public boolean injectEffects(LivingEntity entity) {
        Map<StatusEffect, StatusEffectInstance> map = entity.getActiveStatusEffects();
        ModConfig config = ModConfig.getInstance();

        boolean changed = false;

        for (Iterator<StatusEffect> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            StatusEffect effect = iterator.next();
            StatusEffectInstance instance = map.get(effect);

            boolean isAllowed = config.effectFilter.contains(String.valueOf(Registry.STATUS_EFFECT.getId(effect)));
            if (config.isBlacklist) isAllowed = !isAllowed;

            if (isAllowed) {
                map.put(effect, new StatusEffectInstance(effect,
                        (int) (instance.getDuration() * config.durationMultiplier),
                        (int) ((instance.getAmplifier() + 1) * config.amplifierMultiplier) - 1,
                        instance.isAmbient(),
                        instance.shouldShowParticles(),
                        instance.shouldShowIcon()));
                if (instance.equals(map.get(effect))) changed = true;
                if (entity instanceof ServerPlayerEntity player) {
                    player.networkHandler.sendPacket(new EntityStatusEffectS2CPacket(player.getId(), map.get(effect)));
                }
            } else {
                iterator.remove();
                ((LivingEntityAccess)entity).removeStatusEffect(instance);
                changed = true;
            }
        }

        return changed;
    }
}
