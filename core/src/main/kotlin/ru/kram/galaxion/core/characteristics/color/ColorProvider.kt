package ru.kram.galaxion.core.characteristics.color

interface ColorProvider {

    fun getRandomColor(): Color

    fun getColorByIndex(index: Int): Color?
}