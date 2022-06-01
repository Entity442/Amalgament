package com.harbinger.amalgament.aEntities.Client;

import com.harbinger.amalgament.aEntities.Entities.Glutton;
import com.harbinger.amalgament.amalgament;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GluttonRenderer extends GeoEntityRenderer<Glutton> {
    public GluttonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GluttonModel());
        this.shadowRadius = 1f;
    }
    @Override
    public ResourceLocation getTextureLocation(Glutton instance) {
        return new ResourceLocation(amalgament.MOD_ID, "textures/entity/glutton.png");
    }

    @Override
    public RenderType getRenderType(Glutton animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
