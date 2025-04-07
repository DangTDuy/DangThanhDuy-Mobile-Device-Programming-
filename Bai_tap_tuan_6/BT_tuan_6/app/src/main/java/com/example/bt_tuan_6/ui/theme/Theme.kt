package com.example.bt_tuan_6.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val AppShapes = Shapes() // Định nghĩa Shapes mặc định

@Composable
fun Bt_tuan_6Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette, // Sửa từ FactoryColorPalette
        typography = Typography,
        shapes = AppShapes, // Thêm Shapes
        content = content
    )
}