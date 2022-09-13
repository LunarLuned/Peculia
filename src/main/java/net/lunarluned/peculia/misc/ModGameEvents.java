package net.lunarluned.peculia.misc;

import net.lunarluned.peculia.Peculia;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModGameEvents {

    // Game Event Registry:

    public static final GameEvent ECHOING_MIRROR_USED = new GameEvent("echoing_mirror_used", 16);

    public static void init() {
        Registry.register(Registry.GAME_EVENT, new ResourceLocation(Peculia.MOD_ID, "echoing_mirror_used"), ECHOING_MIRROR_USED);
    }

    public static void registerGameEvents() {
        System.out.println("Registering Game Events for " + Peculia.MOD_ID);
    }
}