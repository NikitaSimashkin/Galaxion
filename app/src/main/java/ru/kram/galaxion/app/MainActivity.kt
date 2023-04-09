package ru.kram.galaxion.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kram.galaxion.levels.LevelsUi
import ru.kram.galaxion.menu.MainMenuUi
import ru.kram.galaxion.playground.shoot.CircleShootButton
import ru.kram.galaxion.ui.utils.HideBars

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HideBars()
            CreateNavigationGraph()
        }
    }
}
