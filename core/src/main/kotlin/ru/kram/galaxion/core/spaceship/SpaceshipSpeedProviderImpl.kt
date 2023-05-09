package ru.kram.galaxion.core.spaceship

import ru.kram.galaxion.core.characteristics.speed.DefaultSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.Speed

class SpaceshipSpeedProviderImpl: SpaceshipSpeedProvider {

	override fun getStaySpaceshipSpeed(): Speed {
		val speedY = DefaultSpeedProvider.nullSpeedY
		val speedX = DefaultSpeedProvider.nullSpeedX
		return Speed(speedX, speedY)
	}

	override fun getMoveSpaceshipSpeed(): Speed {
		val speedY = DefaultSpeedProvider.spaceshipSpeedY
		val speedX = DefaultSpeedProvider.nullSpeedX
		return Speed(speedX, speedY)
	}
}