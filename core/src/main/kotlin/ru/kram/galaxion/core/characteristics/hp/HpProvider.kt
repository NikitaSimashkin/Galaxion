package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.enemies.Enemy

interface HpProvider {

    fun <T: Class<out Enemy>> getHp(clazz: T): Hp
}