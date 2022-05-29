package com.harbinger.amalgament.aItems;

import com.harbinger.amalgament.aCore.aCreativeTabs;
import com.harbinger.amalgament.aItems.custom.GluttonSpawn;
import com.harbinger.amalgament.amalgament;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class aItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, amalgament.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public  static final RegistryObject<Item> GLUTTON_SPAWN_EGG = ITEMS.register("gl_spawn_egg",
            () -> new GluttonSpawn( new Item.Properties().tab(aCreativeTabs.AMALGA)));

}
