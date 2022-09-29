package net.lunarluned.peculia.item.custom.scythes;

import net.lunarluned.peculia.config.PeculiaConfig;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.item.custom.scythes.GenericScytheItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.Vec3;

public class SoulScytheItem extends GenericScytheItem {
    public SoulScytheItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }


    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player && player.getRandom().nextInt(100) <= PeculiaConfig.getIntValue("soul_scythe_chance")) {
            player.drop(new ItemStack(ModItems.SOUL), false);
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
