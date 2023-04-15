package ru.kram.galaxion.core.characteristics.direction

import ru.kram.galaxion.core.enemies.Enemy

interface DirectionProvider {

    fun <T: Class<out Enemy>> getDirection(clazz: T): Direction
}