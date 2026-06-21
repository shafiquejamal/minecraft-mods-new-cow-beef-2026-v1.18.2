package com.github.sj.newcowbeef.item

import com.github.sj.newcowbeef.NewCowBeefMod
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, NewCowBeefMod.MOD_ID)

    val GOLD_BEEF: RegistryObject<Item> = ITEMS.register("gold_beef") {
        Item(Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(meatFood(5)))
    }

    val BLUE_BEEF: RegistryObject<Item> = ITEMS.register("blue_beef") {
        Item(Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(meatFood(7)))
    }

    private fun meatFood(nutrition: Int): FoodProperties = FoodProperties.Builder()
        .nutrition(nutrition)
        .saturationMod(0.3f)
        .meat()
        .build()
}
