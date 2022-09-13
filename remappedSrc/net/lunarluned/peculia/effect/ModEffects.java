package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModEffects {
    public static MobEffect ICHOR;
    public static MobEffect VOID_TOUCHED;
    public static MobEffect ANCHORED;
    public static MobEffect ELECTROCUTED;
    public static MobEffect ICHOR_RESISTANCE;
    public static MobEffect DETERMINED;
    public static MobEffect STAGNATED;
    public static MobEffect ECHOING;
    public static MobEffect CURSED;

    public static MobEffect registerIchorStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new IchorEffect(MobEffectCategory.HARMFUL, 15766579));
    }
    public static MobEffect registerCursedStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new IchorEffect(MobEffectCategory.HARMFUL, 15766579));
    }
     public static MobEffect registerVoidTouchedStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new VoidTouchedEffect(MobEffectCategory.HARMFUL, 15750875));
    }
    public static MobEffect registerElectrocutedStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new ElectrocutedEffect(MobEffectCategory.HARMFUL, 3464687));
    }
    public static MobEffect registerAnchoredStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new AnchoredEffect(MobEffectCategory.HARMFUL, 15750875));
    }
    public static MobEffect registerIchorResistanceStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new IchorResistanceEffect(MobEffectCategory.BENEFICIAL, 1385267));
    }
    public static MobEffect registerEchoingStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new EchoingEffect(MobEffectCategory.HARMFUL, 1385267));
    }
    public static MobEffect registerDeterminedStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new DeterminedEffect(MobEffectCategory.BENEFICIAL, 16743526));
    }
    public static MobEffect registerStagnatedStatusEffect(String name) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Peculia.MOD_ID, name), new StagnatedEffect(MobEffectCategory.HARMFUL, 9426908));
    }

    public static void registerIchorEffect() { ICHOR = registerIchorStatusEffect("ichor");}

    public static void registerEchoingEffect() { ECHOING = registerEchoingStatusEffect("echoing");}

    public static void registerAnchoredEffect() { ANCHORED = registerAnchoredStatusEffect("anchored");}

    public static void registerCursedEffect() { CURSED = registerCursedStatusEffect("cursed");}

    public static void registerVoidTouchedEffect() { VOID_TOUCHED = registerVoidTouchedStatusEffect("void_touched"); }

    public static void registerElectrocutedEffect() {
        ELECTROCUTED = registerElectrocutedStatusEffect("electrocuted");
    }

    public static void registerIchorResistanceEffect() { ICHOR_RESISTANCE = registerIchorResistanceStatusEffect("ichor_resistance");}

    public static void registerDeterminedStatusEffect() { DETERMINED = registerDeterminedStatusEffect("determined");}

    public static void registerStagnatedEffect() { STAGNATED = registerStagnatedStatusEffect("stagnated");}
}
