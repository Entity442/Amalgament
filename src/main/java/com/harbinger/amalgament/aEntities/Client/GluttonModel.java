package com.harbinger.amalgament.aEntities.Client;

import com.harbinger.amalgament.aEntities.Entities.monsters.Glutton;
import com.harbinger.amalgament.amalgament;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GluttonModel extends AnimatedGeoModel<Glutton> {
    @Override
    public ResourceLocation getModelLocation(Glutton object) {
        return new ResourceLocation(amalgament.MOD_ID, "geo/glutton.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Glutton object) {
        return new ResourceLocation(amalgament.MOD_ID, "textures/entity/glutton.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Glutton animatable) {
        return new ResourceLocation(amalgament.MOD_ID, "animations/glutton.animation.json");
    }
}
