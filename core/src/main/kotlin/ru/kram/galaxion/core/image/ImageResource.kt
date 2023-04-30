package ru.kram.galaxion.core.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import coil.ImageLoader
import coil.request.ImageRequest
import ru.kram.galaxion.core.image.ImageUtils.toBitmap

internal sealed class ImageResource {

    data class BitmapResource(val bitmap: Bitmap) : ImageResource() {
        override suspend fun loadBitmap(context: Context): Bitmap {
            return bitmap
        }

        override suspend fun loadDrawable(context: Context): Drawable {
            return BitmapDrawable(context.resources, bitmap)
        }
    }

    data class DrawableResource(val drawable: Drawable) : ImageResource() {
        override suspend fun loadDrawable(context: Context): Drawable {
            return drawable
        }

        override suspend fun loadBitmap(context: Context): Bitmap {
            return drawable.toBitmap()
        }
    }


    data class ResourceId(val resourceId: Int) : ImageResource() {
        override suspend fun loadBitmap(context: Context): Bitmap {
            val drawable = loadDrawable(context)
            return drawable.toBitmap()
        }

        override suspend fun loadDrawable(context: Context): Drawable {
            return context.resources.getDrawable(resourceId, context.theme)
        }
    }

    data class Url(val path: String) : ImageResource() {
        override suspend fun loadBitmap(context: Context): Bitmap? {
            val request = ImageRequest.Builder(context).data(path).build()
            return ImageLoader(context).execute(request).drawable?.toBitmap()
        }

        override suspend fun loadDrawable(context: Context): Drawable? {
            val request = ImageRequest.Builder(context).data(path).build()
            return ImageLoader(context).execute(request).drawable
        }
    }


    data class File(val path: String) : ImageResource() {
        override suspend fun loadBitmap(context: Context): Bitmap? {
            val request = ImageRequest.Builder(context).data(java.io.File(path)).build()
            return ImageLoader(context).execute(request).drawable?.toBitmap()
        }

        override suspend fun loadDrawable(context: Context): Drawable? {
            val data = java.io.File(path)
            return ImageLoader(context).execute(ImageRequest.Builder(context).data(data).build()).drawable
        }
    }

    @Throws(Exception::class)
    abstract suspend fun loadDrawable(context: Context): Drawable?

    @Throws(Exception::class)
    abstract suspend fun loadBitmap(context: Context): Bitmap?
}