package ru.kram.galaxion.core.base

import ru.kram.galaxion.core.characteristics.Position
import ru.kram.galaxion.core.utils.image.ImageResource

internal abstract class PlaygroundObject: GalaxionDrawable {

    protected abstract var position: Position

    protected abstract var image: ImageResource

    abstract var isActive: Boolean
        protected set

    abstract fun updatePosition(newPosition: Position)

    abstract fun kill()
}