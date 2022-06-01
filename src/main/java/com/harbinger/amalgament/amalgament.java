package com.harbinger.amalgament;

import com.harbinger.amalgament.aBlocks.aBlocks;
import com.harbinger.amalgament.aEntities.Client.GluttonRenderer;
import com.harbinger.amalgament.aEntities.aEntities;
import com.harbinger.amalgament.aItems.aItems;
import com.harbinger.amalgament.config.aClientConfig;
import com.harbinger.amalgament.config.aCommonConfig;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


@Mod("amalga")
public class amalgament
{
    public  static final String MOD_ID = "amalga";
    private static final Logger LOGGER = LogManager.getLogger();

    public amalgament() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        aBlocks.register(eventBus);
        aItems.register(eventBus);
        aEntities.register(eventBus);



        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, aClientConfig.SPEC, "amalgament-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, aCommonConfig.SPEC, "amalgament-common.toml");
    }
    private void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(aBlocks.AMALGAM_SPREAD.get(), RenderType.cutout());



        EntityRenderers.register(aEntities.GLUTTON.get(), GluttonRenderer::new);

    }
    private void Setup( final FMLCommonSetupEvent event){


    }

}
