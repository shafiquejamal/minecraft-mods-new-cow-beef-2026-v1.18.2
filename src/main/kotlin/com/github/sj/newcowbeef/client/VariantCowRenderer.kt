package com.github.sj.newcowbeef.client

import net.minecraft.client.model.CowModel
import net.minecraft.client.model.geom.ModelLayers
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.animal.Cow

class VariantCowRenderer<T : Cow>(
    context: EntityRendererProvider.Context,
    private val texture: ResourceLocation,
) : MobRenderer<T, CowModel<T>>(context, CowModel(context.bakeLayer(ModelLayers.COW)), 0.7f) {
    override fun getTextureLocation(entity: T): ResourceLocation = texture
}
