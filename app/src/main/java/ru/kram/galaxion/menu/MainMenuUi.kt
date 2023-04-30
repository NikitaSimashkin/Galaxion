package ru.kram.galaxion.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.kram.galaxion.R
import ru.kram.galaxion.app.LocalMainMenuViewModelFactory
import ru.kram.galaxion.ui.theme.*
import ru.kram.galaxion.ui.utils.BackgroundButtonColor
import ru.kram.galaxion.ui.utils.FullscreenBackground
import ru.kram.galaxion.ui.utils.NullPaddingValues
import ru.kram.galaxion.ui.utils.ScreenPreview

@Composable
fun MainMenuUi(viewModel: MainMenuViewModel = viewModel(factory = LocalMainMenuViewModelFactory.current)) {

	FullscreenBackground(resId = R.drawable.b)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.b),
            contentDescription = "Menu Background",
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(3f)
                .padding(bottom = MaterialTheme.dimens.mainMenuColumnmMargin),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.title2),
                contentDescription = "Title",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.8f),
                contentScale = ContentScale.FillBounds
            )
        }

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
                contentAlignment = Alignment.BottomCenter
            ) {
                PlayButton(
                    text = stringResource(id = R.string.play_button),
                    onClick = { viewModel.openLevels() },
                    modifier = Modifier.fillMaxHeight(0.8f)
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(MaterialTheme.dimens.mainMenuCenterRowMargin)
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(
                start = MaterialTheme.dimens.mainMenuHorizontalMargin,
                end = MaterialTheme.dimens.mainMenuHorizontalMargin,
                bottom = MaterialTheme.dimens.mainMenuBottomMargin
            ),
        ) {
            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.mainMenuBottomButtonsMargin)
            ) {
                SquareMenuButton(
                    R.drawable.main_menu_icon_settings,
                    "Settings",
                    {},
                    Modifier.fillMaxHeight(0.8f)
                )
                SquareMenuButton(
                    R.drawable.main_menu_icon_shop,
                    "Shop",
                    {},
                    Modifier.fillMaxHeight(0.8f)
                )
            }

            SquareMenuButton(
                R.drawable.main_menu_icon_info,
                "Info",
                {},
                Modifier.fillMaxHeight(0.8f).align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun PlayButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.mainMenuButton,
) {
    Button(
        onClick = onClick,
        contentPadding = NullPaddingValues,
        colors = BackgroundButtonColor(MaterialTheme.colors.mainMenuButtonBackground),
        modifier = modifier
            .border(
                shape = MaterialTheme.shapes.mainMenuPlayButton,
                width = MaterialTheme.dimens.mainMenuButtonBorder,
                color = MaterialTheme.colors.mainMenuButtonBorder,
            )
            .aspectRatio(1f),
        shape = MaterialTheme.shapes.mainMenuPlayButton
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun SquareMenuButton(
    imageRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = onClick,
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = MaterialTheme.dimens.mainMenuButtonBorder,
                color = MaterialTheme.colors.mainMenuButtonBorder,
            ),
        contentPadding = PaddingValues(15.dp),
        colors = BackgroundButtonColor(color = MaterialTheme.colors.mainMenuButtonBackground)
    ) {
        Image(
            painterResource(id = imageRes),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.mainMenuIconColor, BlendMode.SrcIn)
        )
    }
}

@ScreenPreview
@Composable
fun MainMenuPreview() {
    MainMenuUi(MainMenuViewModel(NavController(LocalContext.current)))
}