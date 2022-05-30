package com.harbinger.amalgament.aEntities;

import com.harbinger.amalgament.aEntities.Entities.Glutton;
import com.harbinger.amalgament.amalgament;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class aEntities {
    public static DeferredRegister<EntityType<?>> AMALGA_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            amalgament.MOD_ID);
    public static void register(IEventBus eventBus) {
        AMALGA_ENTITIES.register(eventBus);
    }




    public static final RegistryObject<EntityType<Glutton>> GLUTTON =
            AMALGA_ENTITIES.register("glutton",
                    () -> EntityType.Builder.of(Glutton::new, MobCategory.MONSTER)
                            .sized(1.2f, 1.2f)
                            .build(new ResourceLocation(amalgament.MOD_ID, "glutton").toString()));

}
