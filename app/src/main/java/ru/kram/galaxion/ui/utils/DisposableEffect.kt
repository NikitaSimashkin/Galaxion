package ru.kram.galaxion.ui.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun DisposableEffect(
	lifecycleOwner: LifecycleOwner,
	onCreate: () -> Unit = {},
	onStart: () -> Unit = {},
	onResume: () -> Unit = {},
	onPause: () -> Unit = {},
	onStop: () -> Unit = {},
	onDestroy: () -> Unit = {},
) {

	androidx.compose.runtime.DisposableEffect(lifecycleOwner) {
		val observer = LifecycleEventObserver { _, event ->
			when (event) {
				Lifecycle.Event.ON_CREATE -> {
					onCreate()
				}
				Lifecycle.Event.ON_START -> {
					onStart()
				}
				Lifecycle.Event.ON_RESUME -> {
					onResume()
				}
				Lifecycle.Event.ON_PAUSE -> {
					onPause()
				}
				Lifecycle.Event.ON_STOP -> {
					onStop()
				}
				Lifecycle.Event.ON_DESTROY -> {
					onDestroy()
				}
				else -> {}
			}
		}

		lifecycleOwner.lifecycle.addObserver(observer)

		onDispose {
			lifecycleOwner.lifecycle.removeObserver(observer)
		}
	}
}
