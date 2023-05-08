package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.screen.Cell
import ru.kram.galaxion.core.utils.STUB

internal class DefaultSpeedProvider: StartSpeedProvider {

    override fun getSpeed(gameObject: GameObject): Speed {
        return when (gameObject) {
            GameObject.Alien -> getAlienSpeed()
			GameObject.Spaceship -> getSpaceshipSpeed()
        }

        return STUB
    }

	private fun getSpaceshipSpeed(): Speed {
		return Speed(nullSpeedX, nullSpeedY)
	}

    private fun getAlienSpeed(): Speed {
        val speedY = nullSpeedY
        val speedX = alienSpeedX
        return Speed(speedX, speedY)
    }

    companion object {
		val nullSpeedX = Cell.Width(0.0)
        val nullSpeedY = Cell.Height(0.0)

        val alienSpeedX = Cell.Width(150.0)

		val spaceshipSpeedY = Cell.Height(250.0)
    }
}