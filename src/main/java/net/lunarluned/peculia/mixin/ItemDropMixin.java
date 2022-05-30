package net.lunarluned.peculia.mixin;

import net.lunarluned.peculia.misc.PeculiaTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemDropMixin extends Entity {

    @Shadow
    public abstract ItemStack getStack();

    protected ItemDropMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // Detects if an item is in the tag to increase pickup range & make it glow
        if (getStack().isIn(PeculiaTags.ALERTING_ITEMS)) {
            setGlowing(true);
            setBoundingBox(new Box(-2.25, -2.25, -2.25, 2.25, 2.25, 2.25));
            this.setVelocity(this.getVelocity().multiply(0.96D, 0.96D, 0.96D));
        }
    }
}
