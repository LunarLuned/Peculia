package net.lunarluned.peculia.particles;

import com.sun.net.httpserver.Filter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.misc.CoreRegistry;
import net.lunarluned.peculia.mixin.util.SimpleParticleTypeAccessor;
import net.lunarluned.peculia.particles.ChainParticles;
import net.lunarluned.peculia.particles.FlyingPaperParticles;
import net.lunarluned.peculia.particles.IchorLeapParticles;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class ModParticles {
    public static final CoreRegistry<ParticleType<?>> PARTICLES = CoreRegistry.create(Registry.PARTICLE_TYPE_REGISTRY, Peculia.MOD_ID);

    public static final SimpleParticleType FLYING_PAPER = register("flying_paper", false);
    public static final SimpleParticleType CHAIN = register("chain", false);
    public static final SimpleParticleType ICHOR_LEAP = register("ichor_leap", false);
    public static final SimpleParticleType ICHOR = register("ichor", false);

    public static SimpleParticleType register(String id, boolean bl) {
        return PARTICLES.register(id, SimpleParticleTypeAccessor.createSimpleParticleType(bl));
    }

    @Environment(EnvType.CLIENT)
    public static void init() {
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();
        registry.register(FLYING_PAPER, FlyingPaperParticles.Factory::new);
        registry.register(CHAIN, ChainParticles.Factory::new);
        registry.register(ICHOR_LEAP, IchorLeapParticles.IchorLeapParticlesProvider::new);
        registry.register(ICHOR, IchorParticles.Provider::new);
    }
}
