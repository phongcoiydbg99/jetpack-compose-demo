package com.example.firstjen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.firstjen.ui.common.theme.*

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FirstJenTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = TrpTypography().toMaterialTypography(TrpFontFamily),
        shapes = Shapes,
        content = content
    )
}


class MytourTheme : BaseTheme() {
    override fun toLightColors() = TrpColors.toLightColors(
        primary = Color(0xFFFF3366),
        primaryVariant = Color(0xFFFF4171),
        secondary = Color(0xFFFF9233),
    )

    override fun toDarkColors() = TrpColors.toDartColors(
        primary = Color(0xFF6200EE),
        primaryVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6),
    )
}

class PartnerTheme : BaseTheme() {
    override fun toLightColors() = TrpColors.toLightColors(
        primary = Color(0xFF57C478),
        primaryVariant = Color(0xFF61C27E),
        secondary = Color(0xFFFF3366),
    )

    override fun toDarkColors() = TrpColors.toDartColors(
        primary = Color(0xFF6200EE),
        primaryVariant = Color(0xFF3700B3),
        secondary = Color(0xFFFF3366),
    )
}