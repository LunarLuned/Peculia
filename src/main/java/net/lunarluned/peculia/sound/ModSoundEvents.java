package net.lunarluned.peculia.sound;

import net.lunarluned.peculia.Peculia;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

    public static final SoundEvent ECHO_ATTACK_HIT = registerSoundEvent("echo_attack_hit");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Peculia.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static final SoundEvent BLOCK_MYTHRIL_BREAK = registerSoundEvent("block.mythril.break");
    public static final SoundEvent BLOCK_MYTHRIL_STEP = registerSoundEvent("block.mythril.step");
    public static final SoundEvent BLOCK_MYTHRIL_PLACE = registerSoundEvent("block.mythril.place");
    public static final SoundEvent BLOCK_MYTHRIL_HIT = registerSoundEvent("block.mythril.hit");
    public static final SoundEvent BLOCK_MYTHRIL_FALL = registerSoundEvent("block.mythril.fall");

    public static final BlockSoundGroup MYTHRIL = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_MYTHRIL_BREAK, ModSoundEvents.BLOCK_MYTHRIL_STEP, ModSoundEvents.BLOCK_MYTHRIL_PLACE,
            ModSoundEvents.BLOCK_MYTHRIL_HIT, ModSoundEvents.BLOCK_MYTHRIL_FALL);

    public static void registerSounds() {
        System.out.println("Registering Sounds for " + Peculia.MOD_ID);
    }
}
