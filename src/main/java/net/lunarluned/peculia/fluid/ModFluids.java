package net.lunarluned.peculia.fluid;

import net.lunarluned.peculia.Peculia;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid SILLTAR_STILL = register("silltar_still", new SilltarFluid.Still());
    public static final FlowableFluid SILLTAR_FLOWING = register("silltar_flowing", new SilltarFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(Peculia.MOD_ID, name), flowableFluid);
    }
}
