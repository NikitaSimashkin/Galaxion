package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.bridge.Cell
import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB

internal class DefaultSpeedProvider: SpeedProvider {

    override fun <T : Class<out Enemy>> getSpeed(clazz: T): Speed {
        when (clazz) {
            Alien::class.java -> return getAlienSpeed()
        }

        return STUB
    }

    private fun getAlienSpeed(): Speed {
        val speedY = nullSpeedY
        val speedX = alienSpeedX
        return Speed(speedX, speedY)
    }

    companion object {
        private val nullSpeedY = Cell.Height(0.0)

        private val alienSpeedX = Cell.Width(150.0)
    }
}