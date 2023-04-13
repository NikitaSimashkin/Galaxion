package ru.kram.galaxion.core.utils

@JvmInline
internal value class Percent private constructor(
    val value: Double
) {

    companion object {
        fun <T> T.toPercent(): Percent where T : Number, T : Comparable<T> {
            return when {
                this.toDouble() < 0.0 -> Percent(0.0)
                this.toDouble() > 100.0 -> Percent(100.0)
                else -> Percent(this.toDouble())
            }
        }
    }
}