package com.harbinger.amalgament.aEntities.Client;

import com.harbinger.amalgament.aEntities.Entities.projectiles.fleshSpread;
import com.harbinger.amalgament.amalgament;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class fleshSpreadRenderer extends GeoEntityRenderer<fleshSpread> {
    public fleshSpreadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new fleshSpreadModel());
    }

    @Override
    public ResourceLocation getTextureLocation(fleshSpread p_114482_) {
        return new ResourceLocation(amalgament.MOD_ID, "textures/entity/flesh.png");
    }
    @Override
    public RenderType getRenderType(fleshSpread animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
