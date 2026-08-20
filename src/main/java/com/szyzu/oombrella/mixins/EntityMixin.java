package com.szyzu.oombrella.mixins;

import com.szyzu.oombrella.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(
            method = "getLightLevelDependentMagicValue",
            at = @At("HEAD"),
            cancellable = true
    )

    private void oombrella$overrideBrightness(CallbackInfoReturnable<Float> cir){
        Entity self = (Entity)(Object)this;

        if(self instanceof Player player && player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.OOMBRELLA_HELMET.get())){
            cir.setReturnValue(0f);
        }
    }
}
