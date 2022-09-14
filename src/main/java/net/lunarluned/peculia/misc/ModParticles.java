package net.lunarluned.peculia.misc;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.mixin.util.SimpleParticleTypeAccessor;
import net.lunarluned.peculia.particles.FlyingPaperParticles;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class ModParticles {
    public static final CoreRegistry<ParticleType<?>> PARTICLES = CoreRegistry.create(Registry.PARTICLE_TYPE_REGISTRY, Peculia.MOD_ID);

    public static final SimpleParticleType FLYING_PAPER = register("flying_paper", false);

    public static SimpleParticleType register(String id, boolean bl) {
        return PARTICLES.register(id, SimpleParticleTypeAccessor.createSimpleParticleType(bl));
    }

    @Environment(EnvType.CLIENT)
    public static void init() {
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();
        registry.register(FLYING_PAPER, FlyingPaperParticles.Factory::new);
    }
}
