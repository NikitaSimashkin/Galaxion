package ru.kram.galaxion.core.characteristics.speed

interface SpaceshipSpeedProvider {

	fun getStaySpaceshipSpeed(): Speed

	fun getMoveSpaceshipSpeed(): Speed
}