package ru.kram.galaxion.levels

import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.galaxion.app.Screen
import ru.kram.galaxion.data.levels.LevelInfo
import kotlin.math.ceil
import kotlin.random.Random

class LevelsViewModel(private val navController: NavController): ViewModel() {

    private val _levels = MutableStateFlow<List<LevelInfo>>(List(10) { index ->
        LevelInfo(
            isOpened = Random.nextBoolean(),
            name = (index + 1).toString()
        )
    })
    val levels: StateFlow<List<LevelInfo>> = _levels

    fun onClick(level: String) {
		navController.navigate(Screen.PlaygroundScreen.route)
    }

    fun getButtonHeight(screenHeight: Dp, gridMargin: Dp): Dp {
        return (screenHeight - (gridMargin * 2)) / ceil(levels.value.size / COLUMNS.toFloat())
    }

    companion object {

        const val COLUMNS = 3
    }
}