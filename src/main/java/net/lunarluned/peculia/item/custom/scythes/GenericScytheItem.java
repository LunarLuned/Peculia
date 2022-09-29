package net.lunarluned.peculia.item.custom.scythes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

public class GenericScytheItem extends HoeItem {
    public GenericScytheItem(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean canAttackBlock(BlockState state, Level world, BlockPos pos, Player miner) {
        return !miner.isCreative();
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        // Backstab Bonus Knockback

        boolean isBehind = attacker.getLookAngle().dot(target.getLookAngle()) > 0.8;

        if (isBehind) {
            target.invulnerableTime = 0;
            Vec3 vec3d = attacker.getLookAngle();
            target.hurtMarked = true;
            target.push(vec3d.x * 0.65, 0.35, vec3d.z * 0.65);
            target.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 1.0F, 0.8F);
        }

        stack.hurtAndBreak(1, attacker, (player) -> player.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getDestroySpeed(world, pos) != 0.0F) {
            stack.hurtAndBreak(2, miner, (player) -> player.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        }

        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !state.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : 1.5F;
        }
    }
    @Override
    public boolean isCorrectToolForDrops(BlockState blockState) {
        return blockState.is(Blocks.COBWEB);
    }

}
