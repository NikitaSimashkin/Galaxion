package ru.kram.galaxion.core.screen

sealed class Cell {

    @JvmInline
    value class Width(val value: Double) {

        operator fun plus(other: Width) = Width(value + other.value)
        operator fun minus(other: Width) = Width(value - other.value)
        operator fun times(number: Number) = Width(value * number.toDouble())

        operator fun div(number: Number) = Width(value / number.toDouble())
    }

    @JvmInline
    value class Height(val value: Double) {

        operator fun plus(other: Height) = Height(value + other.value)
        operator fun minus(other: Height) = Height(value - other.value)
        operator fun times(number: Number) = Height(value * number.toDouble())

        operator fun div(number: Number) = Height(value / number.toDouble())

    }
}