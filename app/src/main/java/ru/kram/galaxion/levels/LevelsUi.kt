package ru.kram.galaxion.levels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.levels.LevelsViewModel.Companion.COLUMNS
import ru.kram.galaxion.ui.utils.MaxPreview
import ru.kram.galaxion.ui.theme.dimens
import ru.kram.galaxion.ui.theme.levelButton
import ru.kram.galaxion.ui.theme.levelsBackground
import ru.kram.galaxion.ui.utils.getScreenHeight

@Composable
fun LevelsUi(
    levelsViewModel: LevelsViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.levelsBackground)
    ) {

        val buttonHeight = levelsViewModel.getButtonHeight(
            getScreenHeight(),
            MaterialTheme.dimens.levelsGridMargin
        )

        val levelsInfo = levelsViewModel.levels.collectAsState()

        LazyVerticalGrid(
            columns = GridCells.Fixed(COLUMNS),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .padding(MaterialTheme.dimens.levelsGridMargin),
        ) {
            items(levelsInfo.value.size) { index ->
                val levelInfo = levelsInfo.value[index]
                Level(
                    levelInfo = levelInfo,
                    modifier = Modifier
                        .height(buttonHeight)
                        .padding(MaterialTheme.dimens.levelsButtonMargin),
                    onClick = {
                        levelsViewModel.onClick(levelInfo.name)
                    },
                    textStyle = MaterialTheme.typography.levelButton
                )
            }
        }
    }
}

@MaxPreview
@Composable
fun LevelsPreview() {
    LevelsUi()
}