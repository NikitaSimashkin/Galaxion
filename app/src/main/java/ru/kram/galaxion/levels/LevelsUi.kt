package ru.kram.galaxion.levels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.R
import ru.kram.galaxion.app.LocalLevelsViewModelFactory
import ru.kram.galaxion.ui.utils.ScreenPreview
import ru.kram.galaxion.ui.theme.dimens
import ru.kram.galaxion.ui.theme.levelButton
import ru.kram.galaxion.ui.utils.FullscreenBackground
import ru.kram.galaxion.ui.utils.NullPaddingValues

@Composable
fun LevelsUi(
    levelsViewModel: LevelsViewModel = viewModel(factory = LocalLevelsViewModelFactory.current)
) {

	FullscreenBackground(resId = R.drawable.b)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
				.fillMaxWidth()
				.weight(3f)
        ) {

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
        ) {
            val levelsInfo = levelsViewModel.levels.collectAsState()

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.levelsBetweenButtonMargin),
                contentPadding = PaddingValues(
                    start = MaterialTheme.dimens.levelsHorizontalMargin,
                    end = MaterialTheme.dimens.levelsHorizontalMargin
                ),
            ) {
                items(levelsInfo.value.size) { index ->
                    val levelInfo = levelsInfo.value[index]
                    Level(
                        levelInfo = levelInfo,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f),
                        onClick = {
                            levelsViewModel.onClick(levelInfo.name)
                        },
                        textStyle = MaterialTheme.typography.levelButton
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {

        }
    }
}

@ScreenPreview
@Composable
fun LevelsPreview() {
    LevelsUi()
}