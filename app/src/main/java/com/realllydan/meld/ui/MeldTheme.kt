package com.realllydan.meld

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val meld_red = Color(0xFFEE1C3B)
val meld_white = Color.White
val meld_purple_700 = Color(0xFF7B1A67)
val meld_purple_800 = Color(0xFF5D1049)
val meld_purple_900 = Color(0xFF4E0D3A)

val meldColors = lightColors(
    primary = meld_purple_800,
    secondary = meld_red,
    surface = meld_purple_900,
    onSurface = meld_white,
    primaryVariant = meld_purple_700
)

val CardShape = RoundedCornerShape(
    topStart = 15.dp,
    topEnd = 0.dp,
    bottomStart = 0.dp,
    bottomEnd = 15.dp
)

@Composable
fun MeldTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = meldColors, typography = meldTypography) {
        content()
    }
}

