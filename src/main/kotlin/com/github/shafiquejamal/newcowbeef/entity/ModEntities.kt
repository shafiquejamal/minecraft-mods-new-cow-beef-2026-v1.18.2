package com.github.shafiquejamal.newcowbeef.entity

import com.github.shafiquejamal.newcowbeef.NewCowBeefMod
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.entity.SpawnPlacements
import net.minecraft.world.entity.animal.Animal
import net.minecraft.world.entity.animal.Cow
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.event.entity.EntityAttributeCreationEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModEntities {
    val ENTITIES: DeferredRegister<EntityType<*>> = DeferredRegister.create(ForgeRegistries.ENTITIES, NewCowBeefMod.MOD_ID)

    val GOLD_COW: RegistryObject<EntityType<GoldCowEntity>> = ENTITIES.register("gold_cow") {
        EntityType.Builder.of(::GoldCowEntity, MobCategory.CREATURE)
            .sized(0.9f, 1.4f)
            .clientTrackingRange(10)
            .build(entityId("gold_cow"))
    }

    val BLUE_COW: RegistryObject<EntityType<BlueCowEntity>> = ENTITIES.register("blue_cow") {
        EntityType.Builder.of(::BlueCowEntity, MobCategory.CREATURE)
            .sized(0.9f, 1.4f)
            .clientTrackingRange(10)
            .build(entityId("blue_cow"))
    }

    private fun entityId(path: String): String = ResourceLocation.fromNamespaceAndPath(NewCowBeefMod.MOD_ID, path).toString()
}

object ModEntityEvents {
    fun registerAttributes(event: EntityAttributeCreationEvent) {
        event.put(ModEntities.GOLD_COW.get(), Cow.createAttributes().build())
        event.put(ModEntities.BLUE_COW.get(), Cow.createAttributes().build())
    }

    fun registerSpawnPlacements(event: FMLCommonSetupEvent) {
        event.enqueueWork {
            SpawnPlacements.register(
                ModEntities.GOLD_COW.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules,
            )
            SpawnPlacements.register(
                ModEntities.BLUE_COW.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules,
            )
        }
    }
}

@Mod.EventBusSubscriber(modid = NewCowBeefMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object ModBiomeSpawns {
    @SubscribeEvent
    @JvmStatic
    fun onBiomeLoading(event: BiomeLoadingEvent) {
        val biomeName = event.name ?: return

        when {
            biomeName == Biomes.NETHER_WASTES.location() -> {
                event.spawns.addSpawn(MobCategory.CREATURE, spawnerData(ModEntities.GOLD_COW.get()))
            }

            shouldSpawnBlueCow(biomeName, event.category) -> {
                event.spawns.addSpawn(MobCategory.CREATURE, spawnerData(ModEntities.BLUE_COW.get()))
            }
        }
    }

    private fun shouldSpawnBlueCow(biomeName: ResourceLocation, category: Biome.BiomeCategory): Boolean {
        if (biomeName == Biomes.FROZEN_RIVER.location()) {
            return false
        }

        return category == Biome.BiomeCategory.OCEAN || biomeName == Biomes.RIVER.location()
    }

    private fun spawnerData(entityType: EntityType<*>): MobSpawnSettings.SpawnerData =
        MobSpawnSettings.SpawnerData(entityType, 8, 4, 4)
}
