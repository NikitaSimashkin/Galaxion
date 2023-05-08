package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.characteristics.color.ColorProvider
import ru.kram.galaxion.core.characteristics.damage.StartDamageProvider
import ru.kram.galaxion.core.characteristics.direction.StartDirectionProvider
import ru.kram.galaxion.core.characteristics.hp.StartHpProvider
import ru.kram.galaxion.core.characteristics.position.StartPositionProvider
import ru.kram.galaxion.core.characteristics.speed.StartSpeedProvider
import ru.kram.galaxion.core.spaceship.Spaceship

internal class DefaultGameObjectFactory(
	private val startPositionProvider: StartPositionProvider,
	private val startDamageProvider: StartDamageProvider,
	private val startSpeedProvider: StartSpeedProvider,
	private val startHpProvider: StartHpProvider,
	private val startDirectionProvider: StartDirectionProvider,
	private val colorProvider: ColorProvider
): GameObjectFactory {

	override fun createSpaceship(): Spaceship {
		return Spaceship(
			position = startPositionProvider.getStartPosition(GameObject.Spaceship),
			speed = startSpeedProvider.getSpeed(GameObject.Spaceship),
			direction = startDirectionProvider.getDirection(GameObject.Spaceship),
		)
	}

    override fun createRandomColorAlien(): Alien {
        return Alien(
            position = startPositionProvider.getStartPosition(GameObject.Alien),
            damage = startDamageProvider.getDamage(GameObject.Alien),
            hp = startHpProvider.getHp(GameObject.Alien),
            speed = startSpeedProvider.getSpeed(GameObject.Alien),
            direction = startDirectionProvider.getDirection(GameObject.Alien),
            color = colorProvider.getRandomColor(),
        )
    }
}