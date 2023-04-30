package ru.kram.galaxion.core.base

import java.lang.Object

class GameThread(
	private val game: Game
) : Thread() {

	fun pause() {
		synchronized(this) {
			(this as Object).wait()
		}
	}

	fun resume_() {
		synchronized(this) {
			(this as Object).notify()
		}
	}

	override fun run() {
		startPause()
		while (isInterrupted == false) {
			game.updateAllPositions()
			game.tryCreateEnemy()
		}
	}

	private fun startPause() {
		sleep(START_PAUSE)
	}

	companion object {
		private const val START_PAUSE = 2000L
	}
}