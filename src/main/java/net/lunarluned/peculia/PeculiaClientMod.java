package net.lunarluned.peculia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lunarluned.peculia.entity.ModEntities;
import net.lunarluned.peculia.entity.client.CoalGeodeRenderer;

public class PeculiaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.COALGEODE, CoalGeodeRenderer::new);

    }
}