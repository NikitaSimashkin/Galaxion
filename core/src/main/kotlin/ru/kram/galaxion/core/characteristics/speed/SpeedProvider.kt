package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.enemies.Enemy

interface SpeedProvider {

    fun <T: Class<out Enemy>> getSpeed(clazz: T): Speed
}