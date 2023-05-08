package ru.kram.galaxion.core.characteristics.direction

class SpaceshipDirectionProviderImpl: SpaceshipDirectionProvider {

	override fun getUpSpaceshipDirection(): Direction {
		return DefaultDirectionProvider.defaultUpDirection
	}

	override fun getDownSpaceshipDirection(): Direction {
		return DefaultDirectionProvider.defaultDownDirection
	}

}