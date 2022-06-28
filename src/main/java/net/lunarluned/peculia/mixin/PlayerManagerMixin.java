package net.lunarluned.peculia.mixin;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

// Puts a message in the server console to let the user know if a player has the mod installed

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    @Shadow
    @Mutable
    @Final
    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "onPlayerConnect", at = @At(value = "TAIL"))
    public void onPlayerConnectMixin(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
        LOGGER.info(player.getName().getString() + " has Peculia installed");
    }

}
