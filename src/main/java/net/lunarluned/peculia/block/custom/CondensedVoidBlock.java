package net.lunarluned.peculia.block.custom;

import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.EntityTypeTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CondensedVoidBlock extends Block {
    public CondensedVoidBlock(Settings settings) {
        super(settings);
    }


    //public ActionResult OnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        //ItemStack itemStack = player.getStackInHand(hand);
       // if (itemStack.isOf(Items.GLASS_BOTTLE)) {
       //     itemStack.decrement(1);
      //      world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
      //      if (itemStack.isEmpty()) {
      //          player.setStackInHand(hand, new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID));
     //       } else if (!player.getInventory().insertStack(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID))) {
     //           player.dropItem(new ItemStack(ModItems.BOTTLE_OF_CONDENSED_VOID), false);
     //       }

     //       world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
    //    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(new Peculia.CondensedVoidDamageSource(entity), 4);
        entity.slowMovement(state, new Vec3d(0.8999999761581421D, 1.5D, 0.8999999761581421D));
    }
}
