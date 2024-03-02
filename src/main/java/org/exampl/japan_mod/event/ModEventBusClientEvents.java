package org.exampl.japan_mod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.entity.client.FireflyModel;
import org.exampl.japan_mod.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = Japan_mod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.FIREFLY_LAYER, FireflyModel::createBodyLayer);
    }

}
