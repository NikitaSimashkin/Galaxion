package ru.kram.galaxion.core.characteristics.direction

import ru.kram.galaxion.core.base.GameObject

internal class DefaultDirectionProvider: StartDirectionProvider {

    override fun getDirection(gameObject: GameObject): Direction {
        return when(gameObject) {
			GameObject.Alien -> getAlienDirection()
			GameObject.Spaceship -> getSpaceshipDirection()
		}
    }

	private fun getSpaceshipDirection(): Direction {
		return defaultUpDirection
	}

    private fun getAlienDirection(): Direction {
        return defaultHorizontalDirection
    }

    companion object {
        val defaultHorizontalDirection = Direction(180.0)

		val defaultUpDirection = Direction(90.0)
		val defaultDownDirection = Direction(-90.0)
    }
}