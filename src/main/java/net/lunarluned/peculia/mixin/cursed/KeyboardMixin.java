package net.lunarluned.peculia.mixin.cursed;

import net.lunarluned.peculia.effect.ModEffects;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardMixin {
    @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (Minecraft.getInstance().player != null && Minecraft.getInstance().player.hasEffect(ModEffects.CURSED) && !Minecraft.getInstance().player.isSpectator() && !Minecraft.getInstance().player.isCreative()) {
            KeyMapping.releaseAll();
            callbackInfo.cancel();
        }
    }
}
