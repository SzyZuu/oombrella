package com.szyzu.oombrella;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Oombrella.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class OombrellaHelmetEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.phase != TickEvent.Phase.END)
            return;

        boolean wearingHelmet = event.player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.OOMBRELLA_HELMET.get());

        if(wearingHelmet)
            OombrellaLightManager.update(event.player);
        else
            OombrellaLightManager.remove(event.player);
    }
}
