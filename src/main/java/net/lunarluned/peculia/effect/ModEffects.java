package net.lunarluned.peculia.effect;

import net.lunarluned.peculia.Peculia;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ICHOR;
    public static StatusEffect VOID_TOUCHED;
    public static StatusEffect ANCHORED;
    public static StatusEffect ELECTROCUTED;
    public static StatusEffect ICHOR_RESISTANCE;

    public static StatusEffect registerIchorStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new IchorEffect(StatusEffectCategory.HARMFUL, 15766579));
    }
     public static StatusEffect registerVoidTouchedStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new VoidTouchedEffect(StatusEffectCategory.HARMFUL, 15750875));
    }
    public static StatusEffect registerElectrocutedStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new ElectrocutedEffect(StatusEffectCategory.HARMFUL, 3464687));
    }
    public static StatusEffect registerAnchoredStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new AnchoredEffect(StatusEffectCategory.HARMFUL, 15750875));
    }
    public static StatusEffect registerIchorResistanceStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Peculia.MOD_ID, name), new IchorResistanceEffect(StatusEffectCategory.BENEFICIAL, 1385267));
    }

    public static void registerIchorEffect() { ICHOR = registerIchorStatusEffect("ichor");
    }

    public static void registerAnchoredEffect() { ANCHORED = registerAnchoredStatusEffect("anchored");
    }
    public static void registerVoidTouchedEffect() { VOID_TOUCHED = registerVoidTouchedStatusEffect("void_touched"); }

    public static void registerElectrocutedEffect() {
        ELECTROCUTED = registerElectrocutedStatusEffect("electrocuted");
    }
    public static void registerIchorResistanceEffect() { ICHOR_RESISTANCE = registerIchorResistanceStatusEffect("ichor_resistance");}
}
