package ru.kram.galaxion.core.spaceship

import ru.kram.galaxion.core.characteristics.direction.DefaultDirectionProvider
import ru.kram.galaxion.core.characteristics.direction.Direction

class SpaceshipDirectionProviderImpl: SpaceshipDirectionProvider {

	override fun getUpSpaceshipDirection(): Direction {
		return DefaultDirectionProvider.defaultUpDirection
	}

	override fun getDownSpaceshipDirection(): Direction {
		return DefaultDirectionProvider.defaultDownDirection
	}

}