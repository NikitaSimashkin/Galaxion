package ru.kram.galaxion.core.characteristics.position

import ru.kram.galaxion.core.enemies.Enemy

internal interface PositionProvider {

    fun <T: Class<out Enemy>> getStartPosition(clazz: T): Position
}