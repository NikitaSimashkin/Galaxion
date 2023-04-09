package ru.kram.galaxion.levels

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.galaxion.data.levels.LevelInfo
import ru.kram.galaxion.ui.theme.dimens
import ru.kram.galaxion.ui.utils.getScreenHeight
import kotlin.math.ceil
import kotlin.random.Random

class LevelsViewModel(): ViewModel() {

    private val _levels = MutableStateFlow<List<LevelInfo>>(List(10) { index ->
        LevelInfo(
            isOpened = Random.nextBoolean(),
            name = (index + 1).toString()
        )
    })
    val levels: StateFlow<List<LevelInfo>> = _levels

    fun onClick(level: String) {

    }

    fun getButtonHeight(screenHeight: Dp, gridMargin: Dp): Dp {
        return (screenHeight - (gridMargin * 2)) / ceil(levels.value.size / COLUMNS.toFloat())
    }

    companion object {

        const val COLUMNS = 3
    }
}