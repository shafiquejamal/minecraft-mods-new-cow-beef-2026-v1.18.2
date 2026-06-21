package com.github.shafiquejamal.newcowbeef

import com.mojang.logging.LogUtils
import com.github.shafiquejamal.newcowbeef.client.ModEntityRenderers
import com.github.shafiquejamal.newcowbeef.entity.ModEntities
import com.github.shafiquejamal.newcowbeef.entity.ModEntityEvents
import com.github.shafiquejamal.newcowbeef.item.ModItems
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.loading.FMLEnvironment
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT

@Mod(NewCowBeefMod.MOD_ID)
class NewCowBeefMod {
    companion object {
        const val MOD_ID: String = "new_cow_beef"
        private val LOGGER: Logger = LogUtils.getLogger()
    }

    init {
        val modEventBus = MOD_CONTEXT.getKEventBus()
        ModEntities.ENTITIES.register(modEventBus)
        ModItems.ITEMS.register(modEventBus)
        modEventBus.addListener(ModEntityEvents::registerAttributes)
        modEventBus.addListener(ModEntityEvents::registerSpawnPlacements)
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ModEntityRenderers::registerEntityRenderers)
        }
        LOGGER.info("Initializing {} Kotlin Forge bootstrap", MOD_ID)
    }
}
