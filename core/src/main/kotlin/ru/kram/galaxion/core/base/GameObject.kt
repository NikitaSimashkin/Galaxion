package ru.kram.galaxion.core.base

sealed class GameObject {

	object Spaceship: GameObject() {
		enum class ImageState: GameObject.ImageState {
			DEFAULT
		}
	}

	object Alien: GameObject() {
		enum class ImageState: GameObject.ImageState {
			ALIVE,
			DEAD
		}
	}

	interface ImageState
}