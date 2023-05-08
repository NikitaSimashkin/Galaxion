package ru.kram.galaxion.core.image

import ru.kram.galaxion.core.R
import ru.kram.galaxion.core.base.GameObject

internal object ImageProvider {

	fun getImages(gameObject: GameObject): Map<GameObject.ImageState, ImageResource> {
		return when(gameObject) {
			GameObject.Alien -> mapOf (
				GameObject.Alien.ImageState.ALIVE to ImageResource.ResourceId(R.drawable.alien_blue),
				GameObject.Alien.ImageState.DEAD to ImageResource.ResourceId(R.drawable.alien)
			)
			GameObject.Spaceship -> mapOf(
				GameObject.Spaceship.ImageState.DEFAULT to ImageResource.ResourceId(R.drawable.spaceship)
			)
		}
	}
}