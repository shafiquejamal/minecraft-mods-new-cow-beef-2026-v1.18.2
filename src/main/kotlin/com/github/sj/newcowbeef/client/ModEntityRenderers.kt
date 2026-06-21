package com.github.sj.newcowbeef.client

import com.github.sj.newcowbeef.NewCowBeefMod
import com.github.sj.newcowbeef.entity.ModEntities
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(
    modid = NewCowBeefMod.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD,
    value = [Dist.CLIENT],
)
object ModEntityRenderers {
    @SubscribeEvent
    @JvmStatic
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
