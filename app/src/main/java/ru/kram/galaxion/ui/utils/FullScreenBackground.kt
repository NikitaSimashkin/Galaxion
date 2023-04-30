package ru.kram.galaxion.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun FullscreenBackground(
	@DrawableRes resId: Int,
	contentDescription: String = ""
) {

	Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		Image(
			modifier = Modifier.fillMaxSize(),
			painter = painterResource(id = resId),
			contentDescription = contentDescription,
			contentScale = ContentScale.FillBounds
		)
	}
}