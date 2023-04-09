package ru.kram.galaxion.ui.utils

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(device = Devices.AUTOMOTIVE_1024p, group = "LandscapePhone", showBackground = true, widthDp = 720, heightDp = 360)
annotation class LandscapePreview

@Preview(device = Devices.TABLET, group = "Tablet", showBackground = true)
annotation class TabletPreview

@LandscapePreview
@TabletPreview
annotation class MaxPreview