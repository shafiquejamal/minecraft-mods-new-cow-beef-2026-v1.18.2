package com.github.shafiquejamal.newcowbeef.entity

import net.minecraft.server.level.ServerLevel
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.AgeableMob
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.animal.Cow
import net.minecraft.world.level.Level

class GoldCowEntity(entityType: EntityType<out Cow>, level: Level) : Cow(entityType, level) {
    override fun customServerAiStep() {
        super.customServerAiStep()

        val fireResistance = getEffect(MobEffects.FIRE_RESISTANCE)
        if (fireResistance == null || fireResistance.duration <= 20) {
            addEffect(MobEffectInstance(MobEffects.FIRE_RESISTANCE, Int.MAX_VALUE, 0, false, false, false))
        }
    }

    override fun getBreedOffspring(serverLevel: ServerLevel, ageableMob: AgeableMob): Cow {
        return ModEntities.GOLD_COW.get().create(serverLevel)
            ?: throw IllegalStateException("Failed to create gold cow offspring")
    }
}
