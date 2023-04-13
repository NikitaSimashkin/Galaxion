package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.base.PlaygroundObject
import ru.kram.galaxion.core.characteristics.Damage
import ru.kram.galaxion.core.characteristics.Direction
import ru.kram.galaxion.core.characteristics.Hp
import ru.kram.galaxion.core.characteristics.Speed

internal sealed class Enemy: PlaygroundObject() {

    protected abstract var damage: Damage
    protected abstract var speed: Speed
    protected abstract var hp: Hp
    protected abstract var direction: Direction
    protected abstract var isAlive: Boolean
}