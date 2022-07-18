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

    public static final SoundEvent BLOCK_FLUORITE_BREAK = registerSoundEvent("block.fluorite.break");
    public static final SoundEvent BLOCK_FLUORITE_STEP = registerSoundEvent("block.fluorite.step");
    public static final SoundEvent BLOCK_FLUORITE_PLACE = registerSoundEvent("block.fluorite.place");
    public static final SoundEvent BLOCK_FLUORITE_HIT = registerSoundEvent("block.fluorite.hit");
    public static final SoundEvent BLOCK_FLUORITE_FALL = registerSoundEvent("block.fluorite.fall");

    public static final SoundEvent BLOCK_FLUORITE_BRICKS_BREAK = registerSoundEvent("block.fluorite_bricks.break");
    public static final SoundEvent BLOCK_FLUORITE_BRICKS_STEP = registerSoundEvent("block.fluorite_bricks.step");
    public static final SoundEvent BLOCK_FLUORITE_BRICKS_PLACE = registerSoundEvent("block.fluorite_bricks.place");
    public static final SoundEvent BLOCK_FLUORITE_BRICKS_HIT = registerSoundEvent("block.fluorite_bricks.hit");
    public static final SoundEvent BLOCK_FLUORITE_BRICKS_FALL = registerSoundEvent("block.fluorite_bricks.fall");

    public static final SoundEvent BLOCK_CONDENSED_VOID_BREAK = registerSoundEvent("block.condensed_void.break");
    public static final SoundEvent BLOCK_CONDENSED_VOID_STEP = registerSoundEvent("block.condensed_void.step");
    public static final SoundEvent BLOCK_CONDENSED_VOID_PLACE = registerSoundEvent("block.condensed_void.place");
    public static final SoundEvent BLOCK_CONDENSED_VOID_HIT = registerSoundEvent("block.condensed_void.hit");
    public static final SoundEvent BLOCK_CONDENSED_VOID_FALL = registerSoundEvent("block.condensed_void.fall");

    public static final SoundEvent BLOCK_VOID_LAMP_BREAK = registerSoundEvent("block.void_lamp.break");
    public static final SoundEvent BLOCK_VOID_LAMP_STEP = registerSoundEvent("block.void_lamp.step");
    public static final SoundEvent BLOCK_VOID_LAMP_PLACE = registerSoundEvent("block.void_lamp.place");
    public static final SoundEvent BLOCK_VOID_LAMP_HIT = registerSoundEvent("block.void_lamp.hit");
    public static final SoundEvent BLOCK_VOID_LAMP_FALL = registerSoundEvent("block.void_lamp.fall");


    public static final SoundEvent BLOCK_POPROCKS_BREAK = registerSoundEvent("block.poprocks.break");
    public static final SoundEvent BLOCK_POPROCKS_STEP = registerSoundEvent("block.poprocks.step");
    public static final SoundEvent BLOCK_POPROCKS_PLACE = registerSoundEvent("block.poprocks.place");
    public static final SoundEvent BLOCK_POPROCKS_HIT = registerSoundEvent("block.poprocks.hit");
    public static final SoundEvent BLOCK_POPROCKS_FALL = registerSoundEvent("block.poprocks.fall");

    public static final SoundEvent MUSIC_DISC_LULLA = registerSoundEvent("music_disc.lulla");

    public static final SoundEvent EFFECT_ANCHORED_TELEPORT_FAIL = registerSoundEvent("effect.anchored_teleport_fail");

    public static final SoundEvent BLOCK_ICHOR_STICKER_RELEASE = registerSoundEvent("block.ichor_sticker.release");

    public static final BlockSoundGroup MYTHRIL = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_MYTHRIL_BREAK, ModSoundEvents.BLOCK_MYTHRIL_STEP, ModSoundEvents.BLOCK_MYTHRIL_PLACE,
            ModSoundEvents.BLOCK_MYTHRIL_HIT, ModSoundEvents.BLOCK_MYTHRIL_FALL);

    public static final BlockSoundGroup FLUORITE = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_FLUORITE_BREAK, ModSoundEvents.BLOCK_FLUORITE_STEP, ModSoundEvents.BLOCK_FLUORITE_PLACE,
            ModSoundEvents.BLOCK_FLUORITE_HIT, ModSoundEvents.BLOCK_FLUORITE_FALL);

    public static final BlockSoundGroup FLUORITE_BRICKS = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_FLUORITE_BRICKS_BREAK, ModSoundEvents.BLOCK_FLUORITE_BRICKS_STEP, ModSoundEvents.BLOCK_FLUORITE_BRICKS_PLACE,
            ModSoundEvents.BLOCK_FLUORITE_BRICKS_HIT, ModSoundEvents.BLOCK_FLUORITE_BRICKS_FALL);

    public static final BlockSoundGroup CONDENSED_VOID = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_CONDENSED_VOID_BREAK, ModSoundEvents.BLOCK_CONDENSED_VOID_STEP, ModSoundEvents.BLOCK_CONDENSED_VOID_PLACE,
            ModSoundEvents.BLOCK_CONDENSED_VOID_HIT, ModSoundEvents.BLOCK_CONDENSED_VOID_FALL);

    public static final BlockSoundGroup VOID_LAMP = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_VOID_LAMP_BREAK, ModSoundEvents.BLOCK_VOID_LAMP_STEP, ModSoundEvents.BLOCK_VOID_LAMP_PLACE,
            ModSoundEvents.BLOCK_VOID_LAMP_HIT, ModSoundEvents.BLOCK_VOID_LAMP_FALL);

    public static final BlockSoundGroup POPROCKS = new BlockSoundGroup(1f, 1f,
            ModSoundEvents.BLOCK_POPROCKS_BREAK, ModSoundEvents.BLOCK_POPROCKS_STEP, ModSoundEvents.BLOCK_POPROCKS_PLACE,
            ModSoundEvents.BLOCK_POPROCKS_HIT, ModSoundEvents.BLOCK_POPROCKS_FALL);

    public static void registerSounds() {
        System.out.println("Registering Sounds for " + Peculia.MOD_ID);
    }
}
