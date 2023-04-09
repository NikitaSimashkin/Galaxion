package ru.kram.galaxion.core.base

import android.graphics.Bitmap
import android.graphics.Rect

abstract class PlaygroundObject: GalaxionDrawable {

    protected abstract var position: Position

    protected abstract var image: Bitmap

    abstract var isAlive: Boolean
        protected set

    abstract fun updatePosition(newPosition: Position)
}