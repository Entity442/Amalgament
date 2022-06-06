package com.harbinger.amalgament.aEntities.Client;

import com.harbinger.amalgament.aEntities.Entities.projectiles.fleshSpread;
import com.harbinger.amalgament.amalgament;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class fleshSpreadModel extends AnimatedGeoModel<fleshSpread> {
    @Override
    public ResourceLocation getModelLocation(fleshSpread object) {
        return new ResourceLocation(amalgament.MOD_ID, "geo/flesh.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(fleshSpread object) {
        return new ResourceLocation(amalgament.MOD_ID, "textures/entity/flesh.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(fleshSpread animatable) {
        return new ResourceLocation(amalgament.MOD_ID, "animations/flesh.animation.json");
    }
}
