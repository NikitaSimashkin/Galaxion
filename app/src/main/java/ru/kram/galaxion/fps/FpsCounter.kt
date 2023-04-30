package ru.kram.galaxion.fps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class FpsCounter(private val fps: Int) {

	private val internalCounter = MutableLiveData(0)
	val counter: LiveData<Int> = internalCounter

	private val coroutineScope = CoroutineScope(Dispatchers.IO)

	fun start() {
		val delayMills = countDelay()
		coroutineScope.launch {
			while(true) {
				delay(delayMills)
				internalCounter.postValue(((internalCounter.value ?: 0) + 1) % fps)
			}
		}
	}

	fun stop() {
		coroutineScope.cancel()
	}

	private fun countDelay(): Long {
		return 1000L / fps
	}
}