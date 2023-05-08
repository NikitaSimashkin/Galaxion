package ru.kram.galaxion.core.base

import ru.kram.galaxion.core.characteristics.direction.SpaceshipDirectionProvider
import ru.kram.galaxion.core.characteristics.speed.SpaceshipSpeedProvider
import ru.kram.galaxion.core.spaceship.Spaceship

internal interface SpaceshipController {

	fun up(spaceship: Spaceship)

	fun down(spaceship: Spaceship)

	fun stay(spaceship: Spaceship)
}

internal class SpaceshipControllerImpl(
	private val speedProvider: SpaceshipSpeedProvider,
	private val directionProvider: SpaceshipDirectionProvider
): SpaceshipController {

	override fun up(spaceship: Spaceship) {
		spaceship.setNewDirection(directionProvider.getUpSpaceshipDirection())
		spaceship.setNewSpeed(speedProvider.getMoveSpaceshipSpeed())
	}

	override fun down(spaceship: Spaceship) {
		spaceship.setNewDirection(directionProvider.getDownSpaceshipDirection())
		spaceship.setNewSpeed(speedProvider.getMoveSpaceshipSpeed())
	}

	override fun stay(spaceship: Spaceship) {
		spaceship.setNewSpeed(speedProvider.getStaySpaceshipSpeed())
	}
}