package ru.kram.galaxion.core.image

import android.content.Context
import android.graphics.drawable.Drawable

internal class ImageStorage(
	private val resources: List<ImageResource>
) {
	private val cachedImages = hashMapOf<ImageResource, Drawable?>()

	suspend fun loadAll(context: Context) {
		resources.forEach {
			cachedImages[it] = it.loadDrawable(context)
		}
	}

	fun getImage(imageResource: ImageResource): Drawable? {
		return cachedImages[imageResource]
	}
}