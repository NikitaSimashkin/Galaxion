package ru.kram.galaxion.core.enemies

import android.graphics.Canvas
import ru.kram.galaxion.core.characteristics.Position
import ru.kram.galaxion.core.characteristics.Damage
import ru.kram.galaxion.core.characteristics.Direction
import ru.kram.galaxion.core.characteristics.Hp
import ru.kram.galaxion.core.characteristics.Speed
import ru.kram.galaxion.core.utils.image.ImageResource

internal class Alien(
    override var position: Position,
    override var image: ImageResource,
    override var isActive: Boolean,
    override var damage: Damage,
    override var speed: Speed,
    override var hp: Hp,
    override var direction: Direction,
    override var isAlive: Boolean
) : Enemy() {

    override fun updatePosition(newPosition: Position) {
        TODO("Not yet implemented")
    }

    override fun kill() {
        TODO("Not yet implemented")
    }

    override fun draw(canvas: Canvas) {
        TODO("Not yet implemented")
    }


}