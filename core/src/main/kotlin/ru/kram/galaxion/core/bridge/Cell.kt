package ru.kram.galaxion.core.bridge

sealed class Cell {

    @JvmInline
    value class Width(val value: Double) {

        operator fun plus(other: Cell.Width) = Cell.Width(value + other.value)
        operator fun minus(other: Cell.Width) = Cell.Width(value - other.value)
        operator fun times(number: Number) = Cell.Width(value * number.toDouble())
    }

    @JvmInline
    value class Height(val value: Double) {

        operator fun plus(other: Cell.Height) = Cell.Height(value + other.value)
        operator fun minus(other: Cell.Height) = Cell.Height(value - other.value)
        operator fun times(number: Number) = Cell.Height(value * number.toDouble())
    }
}