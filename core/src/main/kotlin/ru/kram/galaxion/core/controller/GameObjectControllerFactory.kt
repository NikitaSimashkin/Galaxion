package ru.kram.galaxion.core.controller

import ru.kram.galaxion.core.spaceship.SpaceshipDirectionProvider
import ru.kram.galaxion.core.spaceship.SpaceshipSpeedProvider
import ru.kram.galaxion.core.spaceship.Spaceship
import ru.kram.galaxion.core.spaceship.SpaceshipController
import ru.kram.galaxion.core.spaceship.SpaceshipControllerImpl
import javax.inject.Inject

internal class GameObjectControllerFactory @Inject constructor(
	val spaceshipSpeedProvider: SpaceshipSpeedProvider,
	val spaceshipDirectionProvider: SpaceshipDirectionProvider
) {

	fun createSpaceshipController(spaceship: Spaceship): SpaceshipController {
		return SpaceshipControllerImpl(spaceship, spaceshipSpeedProvider, spaceshipDirectionProvider)
	}
}