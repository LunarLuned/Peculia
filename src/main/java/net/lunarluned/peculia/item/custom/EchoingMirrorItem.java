package net.lunarluned.peculia.item.custom;
import java.util.Optional;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.misc.ModGameEvents;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.client.util.telemetry.TelemetrySender;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EchoingMirrorItem extends Item {


    public EchoingMirrorItem(FabricItemSettings settings){
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return Ingredient.ofItems(ModItems.BOTTLE_OF_CONDENSED_VOID).test(ingredient) || super.canRepair(stack, ingredient);
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    private void teleportToSpawn(MinecraftServer server, ServerPlayerEntity serverUser, Hand hand){
        ServerWorld overWorld = server.getOverworld();
        BlockPos defaultSpawnPoint = overWorld.getSpawnPos();
        serverUser.teleport(overWorld ,defaultSpawnPoint.getX(), defaultSpawnPoint.getY(), defaultSpawnPoint.getZ(), 0, 0);
        overWorld.playSound( null, serverUser.getPos().x,serverUser.getPos().y,serverUser.getPos().z, ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundCategory.NEUTRAL, 1, 1);
        overWorld.sendEntityStatus(serverUser, (byte)46);
        serverUser.getStackInHand(hand).damage(1, serverUser, p -> p.sendToolBreakStatus(hand));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
            if (!world.isClient) {
                MinecraftServer server = world.getServer();
                ServerPlayerEntity serverUser = server.getPlayerManager().getPlayer(user.getUuid());

                ServerWorld dimension = server.getWorld(serverUser.getSpawnPointDimension());
                BlockPos pos = serverUser.getSpawnPointPosition();
                //if user doesnt have anchored, they can use the mirror
                if (!user.hasStatusEffect(ModEffects.CURSED)) {
                    if (!user.hasStatusEffect(ModEffects.ANCHORED)) {
                        user.emitGameEvent(GameEvent.BLOCK_PLACE);
                        world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundCategory.NEUTRAL, 1f, 1f);
                        world.sendEntityStatus(user, (byte) 46);
                        user.getItemCooldownManager().set(this, 30);

                        if (dimension != null && pos != null) {
                            Optional<Vec3d> userSpawn = PlayerEntity.findRespawnPosition(dimension, pos, 0f, false, user.isAlive());
                            if (userSpawn.isPresent()) {
                                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                                serverUser.teleport(dimension, userSpawn.get().x, userSpawn.get().y, userSpawn.get().z, 0f, 0f);
                                dimension.playSound(null, serverUser.getPos().x, serverUser.getPos().y, serverUser.getPos().z, ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundCategory.NEUTRAL, 1f, 1f);
                                dimension.sendEntityStatus(serverUser, (byte) 46);
                                serverUser.getStackInHand(hand).damage(1, serverUser, p -> p.sendToolBreakStatus(hand));
                                user.addStatusEffect(new StatusEffectInstance(ModEffects.ANCHORED, 120, 0));
                            } else {
                                user.emitGameEvent(GameEvent.BLOCK_PLACE);
                                teleportToSpawn(server, serverUser, hand);
                                user.addStatusEffect(new StatusEffectInstance(ModEffects.ANCHORED, 120, 0));
                            }
                        } else {
                            user.emitGameEvent(GameEvent.BLOCK_PLACE);
                            teleportToSpawn(server, serverUser, hand);
                            user.addStatusEffect(new StatusEffectInstance(ModEffects.ANCHORED, 120, 0));
                        }
                    } else {
                        //this should make it so that if you have anchored your mirror will take more damage and give you void touched
                        user.addStatusEffect(new StatusEffectInstance(ModEffects.VOID_TOUCHED, 360, 0));
                        serverUser.getStackInHand(hand).damage(3, serverUser, p -> p.sendToolBreakStatus(hand));
                        world.playSound(null, user.getPos().x, user.getPos().y, user.getPos().z, ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, SoundCategory.NEUTRAL, 1f, 1f);
                        user.getItemCooldownManager().set(this, 300);
                        user.damage(new Peculia.EchoingMirrorDamageSource(user), 6.0F);
                    }
                    return TypedActionResult.success(itemStack, world.isClient());
                }
            }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
