package com.github.sj.newcowbeef

import com.mojang.logging.LogUtils
import com.github.sj.newcowbeef.entity.ModEntities
import com.github.sj.newcowbeef.item.ModItems
import net.minecraftforge.fml.common.Mod
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
        LOGGER.info("Initializing {} Kotlin Forge bootstrap", MOD_ID)
    }
}
