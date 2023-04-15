package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB

internal class DefaultHpProvider: HpProvider {

    override fun <T : Class<out Enemy>> getHp(clazz: T): Hp {
        when (clazz) {
            Alien::class.java -> return getAlienHp()
        }

        return STUB
    }

    private fun getAlienHp(): Hp {
        return alienHp
    }

    companion object {
        private val alienHp = Hp(200.0)
    }
}