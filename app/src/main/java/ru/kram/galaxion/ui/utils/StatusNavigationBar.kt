package ru.kram.galaxion.ui.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun AppCompatActivity.HideBars() {
    supportActionBar?.hide()
    WindowCompat.setDecorFitsSystemWindows(window, false)
    val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
    windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
    windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
    windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}