package net.lunarluned.peculia.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.lunarluned.peculia.Peculia;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType ICHOR_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Peculia.MOD_ID, "ichor_particle"),
                ICHOR_PARTICLE);
    }
}
