package net.lunarluned.peculia.common.registry.entity.living_entities.coal_geode;

import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.schedule.Activity;
import org.spongepowered.include.com.google.common.collect.ImmutableSet;

public class CoalGeodeBrain {

    public static Brain<?> makeBrain(Brain<CoalGeodeEntity> brain) {
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        return brain;
    }
    // work on later, we're getting somewhere methinks
    /*
    private static void addCoreActivities(Brain<CoalGeodeEntity> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(
                new AnimalPanic(0.45f),
                new LookAtTargetSink(45, 90),
                new MoveToTargetSink(),
                new CountDownCooldownTicks(MemoryModuleType.TEMPTATION_COOLDOWN_TICKS)));
    }


    private static void addIdleActivities(Brain<CoalGeodeEntity> brain) {
        brain.addActivityWithConditions(
                Activity.IDLE,
                ImmutableList.of(
                        Pair.of(0, new RunSometimes<>(new SetEntityLookTarget(EntityType.PLAYER, 6.0F), UniformInt.of(10, 30))),
                        Pair.of(1, new FollowTemptation(livingEntity -> 1.0F))
                        ));
    }

    public static Ingredient getTemptations() {
        return CoalGeodeEntity.TEMPTATION_ITEM;

    }

     */
}
