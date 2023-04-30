package ru.kram.galaxion.core.image

import android.content.Context
import android.graphics.drawable.Drawable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class ImageStorage(
	private val resources: List<ImageResource>
) {

	private val coroutineScope = CoroutineScope(Dispatchers.IO)
	private val cachedImages = hashMapOf<ImageResource, Drawable?>()

	fun loadAll(context: Context) {
		coroutineScope.launch {
			resources.forEach {
				cachedImages[it] = it.loadDrawable(context)
			}
		}
	}

	fun getImage(imageResource: ImageResource): Drawable? {
		return cachedImages[imageResource]
	}
}