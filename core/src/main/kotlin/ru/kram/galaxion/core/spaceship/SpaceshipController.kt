package ru.kram.galaxion.core.spaceship

interface SpaceshipController {

	fun up()

	fun down()

	fun stay()
}

internal class SpaceshipControllerImpl(
	private val spaceship: Spaceship,
	private val speedProvider: SpaceshipSpeedProvider,
	private val directionProvider: SpaceshipDirectionProvider
) : SpaceshipController {

	override fun up() {
		spaceship.setNewDirection(directionProvider.getUpSpaceshipDirection())
		spaceship.setNewSpeed(speedProvider.getMoveSpaceshipSpeed())
	}

	override fun down() {
		spaceship.setNewDirection(directionProvider.getDownSpaceshipDirection())
		spaceship.setNewSpeed(speedProvider.getMoveSpaceshipSpeed())
	}

	override fun stay() {
		spaceship.setNewSpeed(speedProvider.getStaySpaceshipSpeed())
	}
}