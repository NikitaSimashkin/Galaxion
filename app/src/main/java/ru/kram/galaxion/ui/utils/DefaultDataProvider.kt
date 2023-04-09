package ru.kram.galaxion.ui.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object DefaultDataProvider {

    fun getColors(n: Int): List<Color> {
        return (0.. n).map {
            Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        }
    }

    fun getDefaultListColors(): List<Color> {
        return listOf(Color.Red, Color.Green, Color.Blue)
    }

    fun getOnClickListeners(n: Int): List<() -> Unit> {
        return (0.. n).map { {} }
    }
}