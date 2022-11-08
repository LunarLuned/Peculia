package net.lunarluned.peculia.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class IchorParticles extends RisingParticle {


    IchorParticles(ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
        super(clientLevel, d, e, f, g, h, i);
        this.speedUpWhenYMotionIsBlocked = true;
        this.lifetime = 5 + this.random.nextInt(3);
        this.setParticleSpeed(0D, 0D, 0D);
        this.xd *= 0.01f;
        this.yd *= 0.01f;
        this.zd *= 0.01f;
        this.yd += 0.01f;
        this.quadSize = 0.45f;
        this.lifetime = 8;
    }


    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double d, double e, double f) {
        this.setBoundingBox(this.getBoundingBox().move(d, e, f));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float f) {
        float g = ((float)this.age + f) / (float)this.lifetime;
        return this.quadSize * (1.0F - g * g * 0.5F);
    }

    public int getLightColor(float f) {
        float g = ((float)this.age + f) / (float)this.lifetime;
        g = Mth.clamp(g, 0.0F, 1.0F);
        int i = super.getLightColor(f);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(g * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        @Override
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            IchorParticles ichorburnParticles = new IchorParticles(clientLevel, d, e, f, g, h, i);
            ichorburnParticles.pickSprite(this.sprite);
            ichorburnParticles.setColor(1.0f, 1.0f, 1.0f);
            return ichorburnParticles;
        }
    }
}

