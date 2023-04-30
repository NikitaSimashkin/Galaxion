package ru.kram.galaxion.core.screen

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.speed.Speed
import ru.kram.galaxion.core.image.ImageResource
import kotlin.math.cos
import kotlin.math.sin

internal abstract class PlaygroundObject {

    abstract var position: Position
		protected set

    abstract var imageResources: Map<GameObject.State, ImageResource>
		protected set

	protected abstract var state: GameObject.State

	protected abstract var direction: Direction

	protected abstract var speed: Speed

    abstract var isActive: Boolean
        protected set

    abstract fun kill()

	open fun updatePosition(delta: Long) {
		position = countPosition(delta)
	}

	open fun setNewPosition(newPosition: Position) {
		position = newPosition
	}

	protected open fun countPosition(delta: Long): Position {

		val deltaX = speed.speedX * delta / 1000.0
		val deltaY = speed.speedY * delta / 1000.0

		val newX = position.topLeftX + deltaX * cos(direction.angle)
		val newY = position.topLeftY + deltaY * sin(direction.angle)

		return Position(
			newX,
			newY,
			(newX + position.bottomRightX - position.topLeftX),
			(newY + position.bottomRightY - position.topLeftY)
		)
	}
}