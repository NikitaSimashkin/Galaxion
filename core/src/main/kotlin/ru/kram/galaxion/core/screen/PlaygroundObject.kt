package ru.kram.galaxion.core.screen

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.VisualState
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.position.DefaultPositionProvider
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.speed.Speed
import ru.kram.galaxion.core.image.ImageResource
import ru.kram.galaxion.core.utils.Time
import kotlin.math.cos
import kotlin.math.sin

internal abstract class PlaygroundObject {

	abstract var position: Position
		protected set

	abstract val imageResources: Map<VisualState, ImageResource>

	abstract var visualState: VisualState
		protected set

	protected abstract var direction: Direction

	protected abstract var speed: Speed

	abstract var isActive: Boolean
		protected set

	val image get() = imageResources[visualState]

	abstract fun kill()

	open fun updatePosition(delta: Time) {
		position = countPosition(delta)
	}

	open fun setNewPosition(newPosition: Position) {
		position = newPosition
	}

	protected open fun countPosition(delta: Time): Position {

		val percentOfSecond = Time.getPercentOfSecond(delta)
		val deltaX = speed.speedX * percentOfSecond
		val deltaY = speed.speedY * percentOfSecond

		val newTopLeftX = position.topLeftX + deltaX * cos(direction.angle)
		val newBottomRightX = newTopLeftX + (position.bottomRightX - position.topLeftX)

		val newTopLeftY = position.topLeftY + deltaY * sin(direction.angle)
		val newBottomRightY = newTopLeftY + position.bottomRightY - position.topLeftY

		return if (
			newTopLeftY.value < DefaultPositionProvider.verticalOffset.value ||
			newBottomRightY.value > (ScreenSizeProvider.fieldHeight - DefaultPositionProvider.verticalOffset).value
		) {
			Position(
				newTopLeftX,
				position.topLeftY,
				newBottomRightX,
				position.bottomRightY
			)
		} else {
			Position(
				newTopLeftX,
				newTopLeftY,
				newBottomRightX,
				newBottomRightY
			)
		}
	}
}