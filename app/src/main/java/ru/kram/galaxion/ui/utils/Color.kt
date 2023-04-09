package ru.kram.galaxion.ui.utils

import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BackgroundButtonColor(color: Color) = ButtonDefaults.buttonColors(backgroundColor = color)