package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.utils.STUB

internal class DefaultHpProvider: StartHpProvider {

    override fun getHp(gameObject: GameObject): Hp {
       return when(gameObject) {
		   GameObject.Alien -> getAlienHp()
		   else -> STUB
	   }
    }

    private fun getAlienHp(): Hp {
        return alienHp
    }

    companion object {
        private val alienHp = Hp(200.0)
    }
}