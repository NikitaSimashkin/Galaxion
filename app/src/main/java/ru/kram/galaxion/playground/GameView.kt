package ru.kram.galaxion.playground

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.Log
import android.view.SurfaceView
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.findViewTreeLifecycleOwner
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.fps.FpsCounter

@Composable
fun GameView(game: Game, modifier: Modifier = Modifier) {

	val fpsCounter = FpsCounter(60)
	fpsCounter.start()

	Box(modifier = modifier) {
		AndroidView(
			factory = { context ->
				val view = SurfaceView(context)
				view.setZOrderOnTop(true)
				view.holder.setFormat(PixelFormat.TRANSLUCENT)
				view.setBackgroundColor(android.graphics.Color.TRANSPARENT)
				view
			},
			modifier = Modifier.matchParentSize()
		) { view ->
			view.post {
				fpsCounter.counter.observeForever {
					val canvas = view.holder.lockCanvas()
					if (canvas != null) {
						canvas.clear()
						game.drawAll(view.context, canvas)
						view.holder.unlockCanvasAndPost(canvas)
					}
				}
			}
		}
	}
}

private fun Canvas.clear() {
	drawRect(0f, 0f, width.toFloat(), height.toFloat(), Paint().also { it.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) })
}