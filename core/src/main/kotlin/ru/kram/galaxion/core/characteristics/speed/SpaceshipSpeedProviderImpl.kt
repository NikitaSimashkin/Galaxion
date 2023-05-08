package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.screen.Cell

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