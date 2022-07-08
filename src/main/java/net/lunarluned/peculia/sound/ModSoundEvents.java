package net.lunarluned.peculia.sound;

import net.lunarluned.peculia.Peculia;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

    public static final SoundEvent ECHO_ATTACK_HIT = registerSoundEvent("effect.echo.attack.hit");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Peculia.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static final SoundEvent BLOCK_MYTHRIL_BREAK = registerSoundEvent("block.mythril.break");
    public static final SoundEvent BLOCK_MYTHRIL_STEP = registerSoundEvent("block.mythril.step");
    public static final SoundEvent BLOCK_MYTHRIL_PLACE = registerSoundEvent("block.mythril.place");
    public static final SoundEvent BLOCK_MYTHRIL_HIT = registerSoundEvent("block.mythril.hit");
    public static final SoundEvent BLOCK_MYTHRIL_FALL = registerSoundEvent("block.mythril.fall");

    public static final SoundEvent BLOCK_POPROCKS_BREAK = registerSoundEvent("block.poprocks.break");
    public static final SoundEvent BLOCK_POPROCKS_STEP = registerSoundEvent("block.poprocks.step");
    public static final SoundEvent BLOCK_POPROCKS_PLACE = registerSoundEvent("block.poprocks.place");
    public static final SoundEvent BLOCK_POPROCKS_HIT = registerSoundEvent("block.poprocks.hit");
    public static final SoundEvent BLOCK_POPROCKS_FALL = registerSoundEvent("block.poprocks.fall");

    public static final SoundEvent EFFECT_ANCHORED_TELEPORT_FAIL = registerSoundEvent("effect.anchored_teleport_fail");

    public static final SoundEvent BLOCK_ICHOR_STICKER_RELEASE = registerSoundEvent("block.ichor_sticker.release");

    public static final BlockSoundGroup MYTHRIL = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_MYTHRIL_BREAK, ModSoundEvents.BLOCK_MYTHRIL_STEP, ModSoundEvents.BLOCK_MYTHRIL_PLACE,
            ModSoundEvents.BLOCK_MYTHRIL_HIT, ModSoundEvents.BLOCK_MYTHRIL_FALL);

    public static final BlockSoundGroup POPROCKS = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_POPROCKS_BREAK, ModSoundEvents.BLOCK_POPROCKS_STEP, ModSoundEvents.BLOCK_POPROCKS_PLACE,
            ModSoundEvents.BLOCK_POPROCKS_HIT, ModSoundEvents.BLOCK_POPROCKS_FALL);

    public static void registerSounds() {
        System.out.println("Registering Sounds for " + Peculia.MOD_ID);
    }
}
