package ru.kram.galaxion.playground.game

import android.graphics.*
import android.view.SurfaceView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ru.kram.galaxion.core.base.GameState
import ru.kram.galaxion.playground.PlaygroundViewModel
import ru.kram.galaxion.ui.utils.DisposableEffect

private const val TAG = "GameView"

@Composable
fun GameView(viewModel: PlaygroundViewModel, modifier: Modifier = Modifier) {

	val coroutineScope = rememberCoroutineScope()
	val context = LocalContext.current
	var isStarted by remember { mutableStateOf(false) }

	Box(
		modifier = modifier
			.background(Color.Transparent)
	) {
		AndroidView(
			factory = { context ->
				val view = SurfaceView(context)
				view.setZOrderOnTop(true)
				view.holder.setFormat(PixelFormat.TRANSPARENT)
				view
			},
			modifier = Modifier.fillMaxSize()
		) { view ->
			if (isStarted) return@AndroidView
			view.post {
				viewModel.startGame(context, view.width.toDouble(), view.height.toDouble())
				coroutineScope.launch(Dispatchers.Default) {
					while (isActive) {
						if (viewModel.game?.gameState != GameState.ACTIVE) continue
						val canvas = view.holder.lockCanvas()
						if (canvas != null) {
							canvas.clear()
							viewModel.game?.drawAll(canvas)
							view.holder.unlockCanvasAndPost(canvas)
						}
					}
				}
			}
			isStarted = true
		}
	}

	DisposableEffect(
		LocalLifecycleOwner.current,
		onStop = {
			coroutineScope.cancel()
			viewModel.stopGame()
		}
	)
}

private fun Canvas.clear() {
	drawRect(
		0f,
		0f,
		width.toFloat(),
		height.toFloat(),
		Paint().also { it.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) })
}