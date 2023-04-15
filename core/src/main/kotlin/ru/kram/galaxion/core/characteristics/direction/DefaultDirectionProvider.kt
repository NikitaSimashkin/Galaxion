package ru.kram.galaxion.core.characteristics.direction

import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB

internal class DefaultDirectionProvider: DirectionProvider {

    override fun <T : Class<out Enemy>> getDirection(clazz: T): Direction {
        when (clazz) {
            Alien::class.java -> return getAlienDirection()
        }

        return STUB
    }

    private fun getAlienDirection(): Direction {
        return defaultHorizontalDirection
    }

    companion object {
        private val defaultHorizontalDirection = Direction(180.0)
    }
}