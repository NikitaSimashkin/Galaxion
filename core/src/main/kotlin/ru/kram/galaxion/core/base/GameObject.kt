package ru.kram.galaxion.core.base

sealed class GameObject {
	object Alien: GameObject() {
		enum class State: GameObject.State {
			ALIVE,
			DEAD
		}
	}

	interface State
}