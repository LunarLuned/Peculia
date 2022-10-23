package net.lunarluned.peculia.mixin.util;

import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccessor {

    @SuppressWarnings("ALL")
    @Invoker("<init>")
    static WoodType newWoodType(String name) {
        throw new AssertionError();
    }

    @SuppressWarnings("ALL")
    @Invoker("register")
    static WoodType registerNew(WoodType type) {
        throw new AssertionError();
    }
}
