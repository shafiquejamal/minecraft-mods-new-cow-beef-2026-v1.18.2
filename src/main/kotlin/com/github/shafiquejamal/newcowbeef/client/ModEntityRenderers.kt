package com.github.shafiquejamal.newcowbeef.client

import com.github.shafiquejamal.newcowbeef.NewCowBeefMod
import com.github.shafiquejamal.newcowbeef.entity.ModEntities
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.event.EntityRenderersEvent

object ModEntityRenderers {
    fun registerEntityRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(ModEntities.GOLD_COW.get()) { context ->
            VariantCowRenderer(context, texture("textures/entity/cow/gold_cow.png"))
        }
        event.registerEntityRenderer(ModEntities.BLUE_COW.get()) { context ->
            VariantCowRenderer(context, texture("textures/entity/cow/blue_cow.png"))
        }
    }

    private fun texture(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(NewCowBeefMod.MOD_ID, path)
}
