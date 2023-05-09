package ru.kram.galaxion.core.spaceship

import ru.kram.galaxion.core.characteristics.speed.Speed

interface SpaceshipSpeedProvider {

	fun getStaySpaceshipSpeed(): Speed

	fun getMoveSpaceshipSpeed(): Speed
}