package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.core.characteristics.damage.Damage
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.hp.Hp
import ru.kram.galaxion.core.characteristics.position.Position
import ru.kram.galaxion.core.characteristics.speed.Speed

internal interface EnemyFactory {

    fun createRandomColorAlien(): Alien
}