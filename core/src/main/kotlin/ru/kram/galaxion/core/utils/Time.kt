package ru.kram.galaxion.core.utils

import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@JvmInline
value class Time(val value: Double) {

	fun toDuration(): Duration {
		return value.toDuration(DurationUnit.NANOSECONDS)
	}

	companion object {

		const val SECOND = 1_000_000_000.0

		fun getCurrentTime(): Time {
			return Time(System.nanoTime().toDouble())
		}

		fun getPercentOfSecond(time: Time): Double {
			return time.value / SECOND
		}
	}
}