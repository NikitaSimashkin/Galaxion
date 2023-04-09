package ru.kram.galaxion.levels

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewParameter
import ru.kram.galaxion.data.levels.LevelInfo
import ru.kram.galaxion.ui.theme.levelButton
import ru.kram.galaxion.ui.theme.levelButtonShape
import ru.kram.galaxion.ui.theme.levelClose
import ru.kram.galaxion.ui.theme.levelOpen
import ru.kram.galaxion.ui.utils.MaxPreview
import ru.kram.galaxion.ui.utils.NullButtonPadding

@Composable
fun Level(
    levelInfo: LevelInfo,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.levelButton,
    buttonOpenColor: Color = MaterialTheme.colors.levelOpen,
    buttonCloseColor: Color = MaterialTheme.colors.levelClose,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (levelInfo.isOpened) buttonOpenColor else buttonCloseColor
        ),
        contentPadding = NullButtonPadding,
        modifier = modifier,
        shape = MaterialTheme.shapes.levelButtonShape
    ) {
        Text(
            text = levelInfo.name,
            modifier = textModifier,
            style = textStyle
        )
    }
}

@MaxPreview
@Composable
fun LevelPreview(
    @PreviewParameter(LevelInfoPreviewProvider::class)
    info: LevelInfo
) {
    Level(info)
}