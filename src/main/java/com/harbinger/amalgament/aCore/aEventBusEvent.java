package com.harbinger.amalgament.aCore;

import com.harbinger.amalgament.aEntities.Entities.monsters.Glutton;
import com.harbinger.amalgament.aEntities.Entities.projectiles.fleshSpread;
import com.harbinger.amalgament.aEntities.aEntities;
import com.harbinger.amalgament.amalgament;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = amalgament.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class aEventBusEvent {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(aEntities.GLUTTON.get(), Glutton.setAttributes());
        event.put(aEntities.FLESH.get(), fleshSpread.setAttributes());

}
}
