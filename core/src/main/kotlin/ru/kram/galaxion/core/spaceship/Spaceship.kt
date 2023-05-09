package ru.kram.galaxion.core.spaceship

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.VisualState
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.speed.Speed
import ru.kram.galaxion.core.image.ImageProvider
import ru.kram.galaxion.core.image.ImageResource
import ru.kram.galaxion.core.screen.PlaygroundObject

internal class Spaceship(
	override var position: Position,
	override var direction: Direction,
	override var speed: Speed,
) : PlaygroundObject() {

	override val imageResources: Map<VisualState, ImageResource> = ImageProvider.getImages(GameObject.Spaceship)
	override var visualState: VisualState = GameObject.Spaceship.SpaceshipVisualState.DEFAULT

	override var isActive: Boolean = true

	override fun kill() {
		TODO("Not yet implemented")
	}

	fun setNewDirection(direction: Direction) {
		this.direction = direction
	}

	fun setNewSpeed(speed: Speed) {
		this.speed = speed
	}
}