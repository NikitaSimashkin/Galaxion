package ru.kram.galaxion.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.playground.shoot.CircleShootButton
import ru.kram.galaxion.ui.theme.*
import ru.kram.galaxion.ui.theme.mainMenuBackground
import ru.kram.galaxion.ui.utils.MaxPreview

@Composable
fun MainMenuUi(viewModel: MainMenuViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.mainMenuBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(bottom = MaterialTheme.dimens.mainMenuColumnmMargin)
                .background(MaterialTheme.colors.mainMenuHeader)
        ) {}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
                .padding(bottom = MaterialTheme.dimens.mainMenuColumnmMargin)
        ) {
            Spacer(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(MaterialTheme.dimens.mainMenuCenterRowMargin),
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                contentAlignment = Alignment.Center
            ) {
                MainMenuButtons()
            }

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(MaterialTheme.dimens.mainMenuCenterRowMargin)
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(bottom = MaterialTheme.dimens.mainMenuColumnmMargin)
        )
    }
}

@MaxPreview
@Composable
fun MainMenuPreview() {
    MainMenuUi()
}