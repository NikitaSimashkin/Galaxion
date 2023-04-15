package ru.kram.galaxion.core.enemies

import android.graphics.Canvas
import ru.kram.galaxion.core.R
import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.damage.Damage
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.hp.Hp
import ru.kram.galaxion.core.characteristics.speed.Speed
import ru.kram.galaxion.core.utils.image.ImageResource

internal class Alien(
    override var position: Position,
    override var damage: Damage,
    override var speed: Speed,
    override var hp: Hp,
    override var direction: Direction,
    override var color: Color
) : Enemy() {

    override var image: ImageResource = ImageResource.ResourceId(R.drawable.alien_cut)
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