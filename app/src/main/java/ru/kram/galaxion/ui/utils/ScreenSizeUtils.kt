package ru.kram.galaxion.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getScreenHeightDp(): Dp {
    return LocalConfiguration.current.screenHeightDp.dp
}

@Composable
fun getScreenWidthDp(): Dp {
    return LocalConfiguration.current.screenWidthDp.dp
}

@Composable
fun getScreenHeightPx(): Float = with(LocalDensity.current){
	return getScreenHeightDp().toPx()
}

@Composable
fun getScreenWidthPx(): Float = with(LocalDensity.current){
	return getScreenWidthDp().toPx()
}

