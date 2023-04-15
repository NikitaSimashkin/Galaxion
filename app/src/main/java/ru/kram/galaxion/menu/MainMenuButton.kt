package ru.kram.galaxion.menu

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import ru.kram.galaxion.R
import ru.kram.galaxion.app.LocalNavController
import ru.kram.galaxion.app.Screen
import ru.kram.galaxion.ui.theme.*
import ru.kram.galaxion.ui.utils.BackgroundButtonColor
import ru.kram.galaxion.ui.utils.MaxPreview
import ru.kram.galaxion.ui.utils.NullButtonPadding

@Composable
fun MainMenuButtons() {

    val navController = LocalNavController.current

    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.mainMenuButtonMargin)
    ) {
        val buttonModifier = Modifier.weight(1f)

        MainMenuButton(
            text = stringResource(R.string.play_button),
            onClick = {
                navController.navigate(Screen.LevelsScreen.route)
            },
            modifier = buttonModifier
        )

        MainMenuButton(
            text = stringResource(R.string.shop_button),
            onClick = {
                navController.navigate(Screen.PlaygroundScreen.route)
            },
            modifier = buttonModifier
        )

        MainMenuButton(
            text = stringResource(R.string.settings_button),
            onClick = {
                navController.navigate(Screen.SettingsScreen.route)
            },
            modifier = buttonModifier
        )
    }
}

@Composable
fun MainMenuButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.mainMenuButton,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = NullButtonPadding,
        colors = BackgroundButtonColor(MaterialTheme.colors.mainMenuButtonBackground),
        modifier = modifier
            .border(
                width = MaterialTheme.dimens.mainMenuButtonBorder,
                color = MaterialTheme.colors.mainMenuButtonBorder,
                shape = MaterialTheme.shapes.mainMenuButton
            )
            .fillMaxSize(),
        shape = MaterialTheme.shapes.mainMenuButton
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@MaxPreview
@Composable
fun MainMenuButtonsPreview() {
    MainMenuButtons()
}