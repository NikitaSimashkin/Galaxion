package ru.kram.galaxion.menu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kram.galaxion.ui.utils.ComponentPreview

//@Composable
//fun MainMenuButtons(viewModel: MainMenuViewModel) {
//
//    Column(
//        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.mainMenuButtonMargin)
//    ) {
//        val buttonModifier = Modifier.weight(1f)
//
//        MainMenuButton(
//            text = stringResource(R.string.play_button),
//            onClick = {
//                viewModel.openLevels()
//            },
//            modifier = buttonModifier
//        )
//
//        MainMenuButton(
//            text = stringResource(R.string.shop_button),
//            onClick = {
//                viewModel.openShop()
//            },
//            modifier = buttonModifier
//        )
//
//        MainMenuButton(
//            text = stringResource(R.string.settings_button),
//            onClick = {
//                viewModel.openSettings()
//            },
//            modifier = buttonModifier
//        )
//    }
//}

//@Composable
//fun MainMenuButton(
//    text: String,
//    modifier: Modifier = Modifier,
//    textStyle: TextStyle = MaterialTheme.typography.mainMenuButton,
//    onClick: () -> Unit = {}
//) {
//    Button(
//        onClick = onClick,
//        contentPadding = NullButtonPadding,
//        colors = BackgroundButtonColor(MaterialTheme.colors.mainMenuButtonBackground),
//        modifier = modifier
//            .border(
//                width = MaterialTheme.dimens.mainMenuButtonBorder,
//                color = MaterialTheme.colors.mainMenuButtonBorder,
//            )
//    ) {
//        Text(
//            text = text,
//            style = textStyle
//        )
//    }
//}