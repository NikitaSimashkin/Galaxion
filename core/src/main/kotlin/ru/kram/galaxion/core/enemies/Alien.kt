package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.VisualState
import ru.kram.galaxion.core.image.ImageProvider
import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.damage.Damage
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.hp.Hp
import ru.kram.galaxion.core.characteristics.speed.Speed

internal class Alien(
    override var position: Position,
    override var damage: Damage,
    override var speed: Speed,
    override var hp: Hp,
    override var direction: Direction,
    override var color: Color
) : Enemy() {

    override val imageResources = ImageProvider.getImages(GameObject.Alien)
	override var visualState: VisualState = GameObject.Alien.AlienVisualState.ALIVE

    override fun kill() {
        TODO("Not yet implemented")
    }

}