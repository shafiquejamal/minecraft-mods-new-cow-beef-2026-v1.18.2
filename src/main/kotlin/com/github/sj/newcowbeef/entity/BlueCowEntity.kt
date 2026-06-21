package com.github.sj.newcowbeef.entity

import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.AgeableMob
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.animal.Cow
import net.minecraft.world.level.Level

class BlueCowEntity(entityType: EntityType<out Cow>, level: Level) : Cow(entityType, level) {
    override fun getBreedOffspring(serverLevel: ServerLevel, ageableMob: AgeableMob): Cow {
        return ModEntities.BLUE_COW.get().create(serverLevel)
            ?: throw IllegalStateException("Failed to create blue cow offspring")
    }
}
