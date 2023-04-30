package ru.kram.galaxion.core.image

import ru.kram.galaxion.core.R
import ru.kram.galaxion.core.base.GameObject

internal object ImageProvider {

	fun getImages(gameObject: GameObject): Map<GameObject.State, ImageResource> {
		return when(gameObject) {
			GameObject.Alien -> mapOf (
				GameObject.Alien.State.ALIVE to ImageResource.ResourceId(R.drawable.alien),
				GameObject.Alien.State.DEAD to ImageResource.ResourceId(R.drawable.alien)
			)
		}
	}
}