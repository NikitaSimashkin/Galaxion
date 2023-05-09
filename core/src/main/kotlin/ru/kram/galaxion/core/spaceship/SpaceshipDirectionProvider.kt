package ru.kram.galaxion.core.spaceship

import ru.kram.galaxion.core.characteristics.direction.Direction

interface SpaceshipDirectionProvider {

	fun getUpSpaceshipDirection(): Direction

	fun getDownSpaceshipDirection(): Direction
}