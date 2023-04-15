package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.base.PlaygroundObject
import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.core.characteristics.damage.Damage
import ru.kram.galaxion.core.characteristics.direction.Direction
import ru.kram.galaxion.core.characteristics.hp.Hp
import ru.kram.galaxion.core.characteristics.speed.Speed

internal sealed class Enemy: PlaygroundObject() {

    protected abstract var damage: Damage
    protected abstract var speed: Speed
    protected abstract var hp: Hp
    protected abstract var direction: Direction
    protected abstract var color: Color

    protected open var isAlive = true

    override var isActive = true
}