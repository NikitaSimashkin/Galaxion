package ru.kram.galaxion.ui.theme

import androidx.compose.foundation.shape.*
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

internal val DefaultShapes = Shapes(

)

internal val Shapes.mainMenuButton get() = RoundedCornerShape(50.dp)
internal val Shapes.levelButtonShape get() = AbsoluteCutCornerShape(20.dp)