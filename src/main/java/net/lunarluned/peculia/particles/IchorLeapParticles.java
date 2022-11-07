package net.lunarluned.peculia.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Environment(value=EnvType.CLIENT)
public class IchorLeapParticles extends TextureSheetParticle {

    private static final Quaternion QUATERNION = new Quaternion(0F, -0.7F, 0.7F, 0F);
    private final SpriteSet sprites;

    IchorLeapParticles(ClientLevel clientLevel, double d, double e, double f, SpriteSet sprites) {
        super(clientLevel, d, e, f, 0.0, 0.0, 0.0);
        this.sprites = sprites;
        this.speedUpWhenYMotionIsBlocked = true;
        this.lifetime = 5 + this.random.nextInt(3);
        this.setParticleSpeed(0D, 0D, 0D);
        this.xd *= 0.01f;
        this.yd *= 0.01f;
        this.zd *= 0.01f;
        this.yd += 0.01f;
        this.quadSize = 0.45f;
        this.lifetime = 8;
        this.hasPhysics = false;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public float getQuadSize(float f) {
        float g = ((float)this.age + f) / (float)this.lifetime;
        return (this.quadSize * (1f + g) / 2);
    }

    @Override
    public void tick() {
        if(this.age > this.lifetime / 2) {
            this.setAlpha(1.0F - ((float) this.age - (float) (this.lifetime / 2)) / (float) this.lifetime);
        }
        if(this.age++ >= this.lifetime) {
            this.remove();
        }
        else {
            this.setSpriteFromAge(sprites);
        }
    }

    @Override
    public int getLightColor(float f) {
        float g = ((float)this.age) / (float)this.lifetime;
        g = Mth.clamp(g, 1.0f, 0.0f);
        int i = super.getLightColor(f);
        int j = i & 0xFF;
        int k = i >> 16 & 0xFF;
        if ((j += (int)(g * 15.0f * 16.0f)) > 240) {
            j = 240;
        }
        return j | k << 16;
    }

    public void render(@NotNull VertexConsumer buffer, Camera camera, float ticks) {
        Vec3 vec3 = camera.getPosition();
        float x = (float) (Mth.lerp(ticks, this.xo, this.x) - vec3.x());
        float y = (float) (Mth.lerp(ticks, this.yo, this.y) - vec3.y());
        float z = (float) (Mth.lerp(ticks, this.zo, this.z) - vec3.z());

        Vector3f[] vector3fs = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f4 = this.getQuadSize(ticks);

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = vector3fs[i];
            vector3f.transform(QUATERNION);
            vector3f.mul(f4);
            vector3f.add(x, y, z);
        }

        float f7 = this.getU0();
        float f8 = this.getU1();
        float f5 = this.getV0();
        float f6 = this.getV1();
        int j = this.getLightColor(ticks);
        buffer.vertex(vector3fs[0].x(), vector3fs[0].y(), vector3fs[0].z()).uv(f8, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(vector3fs[1].x(), vector3fs[1].y(), vector3fs[1].z()).uv(f8, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(vector3fs[2].x(), vector3fs[2].y(), vector3fs[2].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(vector3fs[3].x(), vector3fs[3].y(), vector3fs[3].z()).uv(f7, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(value=EnvType.CLIENT)
    public static class IchorLeapParticlesProvider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprite;

        public IchorLeapParticlesProvider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        @Override
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            IchorLeapParticles ichorParticles = new IchorLeapParticles(clientLevel, d, e + 0.5, f, sprite);
            ichorParticles.pickSprite(this.sprite);
            ichorParticles.setColor(1.0f, 1.0f, 1.0f);
            return ichorParticles;
        }
    }
}
