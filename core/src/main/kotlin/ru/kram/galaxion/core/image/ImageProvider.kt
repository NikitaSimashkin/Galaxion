package ru.kram.galaxion.core.image

import ru.kram.galaxion.core.R
import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.VisualState

internal object ImageProvider {

	fun getImages(gameObject: GameObject): Map<VisualState, ImageResource> {
		return when(gameObject) {
			GameObject.Alien -> mapOf (
				GameObject.Alien.AlienVisualState.ALIVE to ImageResource.ResourceId(R.drawable.alien_blue),
				GameObject.Alien.AlienVisualState.DEAD to ImageResource.ResourceId(R.drawable.alien)
			)
			GameObject.Spaceship -> mapOf(
				GameObject.Spaceship.SpaceshipVisualState.DEFAULT to ImageResource.ResourceId(R.drawable.spaceship)
			)
		}
	}
}