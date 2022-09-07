package com.example.firstjen.ui.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import com.example.firstjen.ui.theme.*

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LocalTrpTypography = staticCompositionLocalOf<TrpTypography> {
    error("Wrap you content with TrpTheme {} to get access to Backpack typography")
}

@Composable
fun TrpTheme(
    fontFamily: FontFamily = TrpFontFamily,
    content: @Composable () -> Unit,
) {
    val typography = TrpTypography(defaultFontFamily = fontFamily)
    val colors = if (isSystemInDarkTheme()) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(
        LocalTrpTypography provides typography,
        LocalElevationOverlay provides null,
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography.toMaterialTypography(fontFamily),
            shapes = TrpShapes,
        ) {
            CompositionLocalProvider(
                LocalContentAlpha provides 1f,
                content = content,
            )
        }
    }
}

object TrpTheme {

    val typography: TrpTypography
        @Composable
        get() = if (LocalInspectionMode.current) {
            TrpTypography(defaultFontFamily = FontFamily.SansSerif)
        } else {
            LocalTrpTypography.current
        }

    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

}

val TrpShapes: Shapes =
    Shapes(
        small = RoundedCornerShape(TrpBorderRadius.`8dp`),
        medium = RoundedCornerShape(TrpBorderRadius.`12dp`),
        large = RoundedCornerShape(TrpBorderRadius.`16dp`),
    )

fun TrpTypography.toMaterialTypography(fontFamily: FontFamily): Typography =
    Typography(
        defaultFontFamily = fontFamily,
        h1 = trpTextStyleH1,
        h2 = trpTextStyleH2,
        h3 = trpTextStyleH3,
        h4 = trpTextStyleH4,
        h5 = trpTextStyleH5,
        h6 = trpTextStyleH6,
        subtitle1 = trpTextStyleSub1,
        subtitle2 = trpTextStyleSub2,
        body1 = trpTextStyleBody1,
        body2 = trpTextStyleBody2,
        button = trpTextStyleButton,
        caption = trpTextStyleCaption,
        overline = trpTextStyleOverline,
    )
