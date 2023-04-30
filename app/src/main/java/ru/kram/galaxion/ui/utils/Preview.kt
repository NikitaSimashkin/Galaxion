package ru.kram.galaxion.ui.utils

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(device = Devices.AUTOMOTIVE_1024p, group = "LandscapeScreen", showBackground = true, widthDp = 720, heightDp = 360)
annotation class LandscapeScreenPreview

@Preview(device = Devices.TABLET, group = "TabletScreen", showBackground = true)
annotation class TabletScreenPreview

@LandscapeScreenPreview
@TabletScreenPreview
annotation class ScreenPreview

@Preview(device = Devices.AUTOMOTIVE_1024p, group = "LandscapeComponent", showBackground = true)
annotation class LandscapeComponentPreview

@Preview(device = Devices.TABLET, group = "TabletComponent", showBackground = true)
annotation class TabletComponentPreview

@LandscapeComponentPreview
@TabletComponentPreview
annotation class ComponentPreview
