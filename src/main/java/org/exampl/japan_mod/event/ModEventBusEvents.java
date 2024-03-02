package org.exampl.japan_mod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.entity.ModEntities;
import org.exampl.japan_mod.entity.custom.FireflyEntity;

@Mod.EventBusSubscriber(modid = Japan_mod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void regiisterAttributes(EntityAttributeCreationEvent event){
    event.put(ModEntities.FIREFLY.get(), FireflyEntity.createAttrinutes().build());}
}
