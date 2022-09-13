package net.lunarluned.peculia.item.custom;
import java.util.Optional;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lunarluned.peculia.Peculia;
import net.lunarluned.peculia.effect.ModEffects;
import net.lunarluned.peculia.item.ModItems;
import net.lunarluned.peculia.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class EchoingMirrorItem extends Item {

    public EchoingMirrorItem(FabricItemSettings settings){
        super(settings);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(ModItems.BOTTLE_OF_CONDENSED_VOID);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    private void teleportToSpawn(MinecraftServer server, ServerPlayer serverUser, InteractionHand hand){
        ServerLevel overWorld = server.overworld();
        assert overWorld != null;
        BlockPos defaultSpawnPoint = overWorld.getSharedSpawnPos();
        serverUser.teleportTo(overWorld ,defaultSpawnPoint.getX(), defaultSpawnPoint.getY(), defaultSpawnPoint.getZ(), 0, 0);
        overWorld.playSound( null, serverUser.getOnPos().getX(),serverUser.getOnPos().getY(),serverUser.getOnPos().getZ(), ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundSource.NEUTRAL, 1, 1);
        overWorld.broadcastEntityEvent(serverUser, (byte)46);
        serverUser.getItemInHand(hand).hurtAndBreak(1, serverUser, p -> p.broadcastBreakEvent(hand));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, @NotNull InteractionHand hand) {

        ItemStack itemStack = user.getItemInHand(hand);
            if (!world.isClientSide) {
                MinecraftServer server = world.getServer();
                assert server != null;
                ServerPlayer serverUser = server.getPlayerList().getPlayer(user.getUUID());
                assert serverUser != null;
                ServerLevel dimension = server.getLevel(serverUser.getRespawnDimension());
                BlockPos pos = serverUser.getRespawnPosition();

                //if user doesnt have anchored, they can use the mirror

                if (!user.hasEffect(ModEffects.CURSED)) {
                    if (!user.hasEffect(ModEffects.ANCHORED)) {
                        user.gameEvent(GameEvent.TELEPORT);
                        world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundSource.NEUTRAL, 1f, 1f);
                        world.broadcastEntityEvent(user, (byte) 46);
                        user.getCooldowns().addCooldown(this, 30);

                        if (dimension != null && pos != null) {
                            Optional<Vec3> userSpawn = Player.findRespawnPositionAndUseSpawnBlock(dimension, pos, 0f, false, user.isAlive());
                            if (userSpawn.isPresent()) {
                                user.gameEvent(GameEvent.TELEPORT);
                                serverUser.teleportTo(dimension, userSpawn.get().x, userSpawn.get().y, userSpawn.get().z, 0f, 0f);
                                dimension.playSound(null, serverUser.getOnPos().getX(), serverUser.getOnPos().getY(), serverUser.getOnPos().getZ(), ModSoundEvents.ITEM_ECHOING_MIRROR_USE, SoundSource.NEUTRAL, 1f, 1f);
                                dimension.broadcastEntityEvent(serverUser, (byte) 46);
                                user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                                user.addEffect(new MobEffectInstance(ModEffects.ANCHORED, 120, 0));
                            } else {
                                user.gameEvent(GameEvent.TELEPORT);
                                teleportToSpawn(server, serverUser, hand);
                                user.addEffect(new MobEffectInstance(ModEffects.ANCHORED, 120, 0));
                            }
                        } else {
                            user.gameEvent(GameEvent.TELEPORT);
                            teleportToSpawn(server, serverUser, hand);
                            user.addEffect(new MobEffectInstance(ModEffects.ANCHORED, 120, 0));
                        }
                    } else {

                        //this should make it so that if you have anchored your mirror will take more damage and give you void touched

                        user.addEffect(new MobEffectInstance(ModEffects.VOID_TOUCHED, 360, 0));
                        user.getItemInHand(hand).hurtAndBreak(1, user, p -> p.broadcastBreakEvent(hand));
                        world.playSound(null, user.getOnPos().getX(), user.getOnPos().getY(), user.getOnPos().getZ(), ModSoundEvents.EFFECT_ANCHORED_TELEPORT_FAIL, SoundSource.NEUTRAL, 1f, 1f);
                        user.getCooldowns().addCooldown(this, 300);
                        user.hurt(new Peculia.EchoingMirrorDamageSource(), 6.0F);
                    }
                    return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
                }
            }
        return InteractionResultHolder.sidedSuccess(itemStack, user.level.isClientSide());
    }
}
