package net.lunarluned.peculia.item.custom.scythes;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SoulScytheItem extends GenericScytheItem {

    public SoulScytheItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean hurtEnemy(@NotNull ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player && player.getRandom().nextInt(100) <= Peculia.getConfig().items.itemsConfig.itemChances.soul_harvest_chance) {
            if (target.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT) && ((target instanceof Mob) || (target instanceof Player))) {
                target.spawnAtLocation(ModItems.SOUL, 1);
                attacker.level.playSound(null, target.getOnPos(), ModSoundEvents.SCYTHE_OBTAIN_SOUL, SoundSource.PLAYERS, 1.0f, 0.8f + attacker.level.random.nextFloat() * 0.4F);
            }
        }

        // Backstab Bonus Knockback

        boolean isBehind = attacker.getLookAngle().dot(target.getLookAngle()) > 0.8;

        if (isBehind) {
            target.invulnerableTime = 0;
            Vec3 vec3d = attacker.getLookAngle();
            target.hurtMarked = true;
            target.push(vec3d.x * 0.65, 0.35, vec3d.z * 0.65);
            target.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 1.0F, 0.8F);
        }
        return true;
    }
}
