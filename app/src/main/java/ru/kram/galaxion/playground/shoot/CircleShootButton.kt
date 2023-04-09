package ru.kram.galaxion.playground.shoot

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.playground.PlaygroundViewModel
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.DEFAULT_ALPHA
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.START_ANGLE
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.TOUCH_ALPHA
import ru.kram.galaxion.ui.theme.dimens

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CircleShootButton(viewModel: PlaygroundViewModel = viewModel()) {
    Box {

        var touchX by remember { mutableStateOf(0f) }
        var touchY by remember { mutableStateOf(0f) }
        var isPressed by remember { mutableStateOf(false) }

        Canvas(modifier = Modifier
            .aspectRatio(1f)
            .height(MaterialTheme.dimens.shootButton)
            .width(MaterialTheme.dimens.shootButton)
            .background(Color.Transparent)
            .pointerInteropFilter { event ->
                onTouchListener(
                    event,
                    { isPressed = false },
                    {
                        touchX = event.x
                        touchY = event.y
                        isPressed = true
                    }
                )
            }
        ) {
            var lastDrawAngle = START_ANGLE
            val arcLength = 360f / viewModel.sectorsCount
            val touchedSector = if (isPressed) viewModel.shoot(touchX, touchY, size.height) else null

            for (i in viewModel.colorMap) {
                val alpha = if (touchedSector != i.key) DEFAULT_ALPHA else TOUCH_ALPHA
                drawSector(alpha, lastDrawAngle, arcLength, i.value)
                lastDrawAngle += arcLength
            }

        }
    }
}

private fun onTouchListener(event: MotionEvent, up: () -> Unit, down: () -> Unit): Boolean {
    return when (event.actionMasked) {
        MotionEvent.ACTION_UP,
        MotionEvent.ACTION_POINTER_UP -> {
            up()
            true
        }
        MotionEvent.ACTION_DOWN,
        MotionEvent.ACTION_MOVE,
        MotionEvent.ACTION_POINTER_DOWN,
        -> {
            down()
            true
        }
        else -> false
    }
}

private fun DrawScope.drawSector(
    alpha: Float,
    startAngle: Float,
    arcLength: Float,
    color: Color
) {
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = arcLength,
        useCenter = true,
        alpha = alpha,
    )
}

@Composable
@Preview(showBackground = true)
fun CircleShootButtonPreview(
) {
    CircleShootButton()
}