package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.enemies.Enemy

interface DamageProvider {

    fun <T: Class<out Enemy>> getDamage(clazz: T): Damage
}