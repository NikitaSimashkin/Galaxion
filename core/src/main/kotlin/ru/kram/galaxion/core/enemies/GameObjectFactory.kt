package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.spaceship.Spaceship

internal interface GameObjectFactory {

	fun createSpaceship(): Spaceship

    fun createRandomColorAlien(): Alien
}