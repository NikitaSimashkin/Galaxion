package ru.kram.galaxion.core.base

sealed interface GameObject {

	object Spaceship: GameObject {
		internal enum class SpaceshipVisualState: VisualState {
			DEFAULT
		}
	}

	object Alien: GameObject, Hpable, Damagable {
		internal enum class AlienVisualState: VisualState {
			ALIVE,
			DEAD
		}
	}
}

internal interface VisualState

internal sealed interface Hpable
internal sealed interface Damagable