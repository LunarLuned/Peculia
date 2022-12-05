package net.lunarluned.peculia.common.registry.entity;

import com.mojang.serialization.Codec;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.misc.CoreRegistry;
import net.lunarluned.peculia.mixin.util.accessor.MemoryModuleAccessor;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import java.util.Optional;

public class ModMemoryModules {

    public static final CoreRegistry<MemoryModuleType<?>> MEMORY_MODULES = CoreRegistry.create(Registry.MEMORY_MODULE_TYPE_REGISTRY, Peculia.MOD_ID);

    public static final MemoryModuleType<Player> NEAREST_TARGETABLE_PLAYER_NOT_WEARING_MOLD = register("not_wearing_mold");

    public static <U> MemoryModuleType<U> register(String id, Codec<U> codec) {
        return MEMORY_MODULES.register(id, MemoryModuleAccessor.createMemoryModuleType(Optional.of(codec)));
    }

    public static <U> MemoryModuleType<U> register(String id) {
        return MEMORY_MODULES.register(id, MemoryModuleAccessor.createMemoryModuleType(Optional.empty()));
    }

}
