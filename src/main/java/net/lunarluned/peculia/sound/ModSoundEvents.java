package net.lunarluned.peculia.sound;

import net.lunarluned.peculia.Peculia;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

    public static final SoundEvent ECHO_ATTACK_HIT = registerSoundEvent("echo_attack_hit");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Peculia.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
    public static void registerSounds() {
        System.out.println("Registering Sounds for " + Peculia.MOD_ID);
    }
}
