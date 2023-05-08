package ru.kram.galaxion.core.characteristics.direction

interface SpaceshipDirectionProvider {

	fun getUpSpaceshipDirection(): Direction

	fun getDownSpaceshipDirection(): Direction
}