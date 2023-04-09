package ru.kram.galaxion.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getScreenHeight(): Dp {
    return LocalConfiguration.current.screenHeightDp.dp
}

@Composable
fun getScreenWidth(): Dp {
    return LocalConfiguration.current.screenWidthDp.dp
}