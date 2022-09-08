package com.example.firstjen.ui.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import com.example.firstjen.ui.common.theme.TrpColors.Companion.toMaterialColors

private val LocalTrpTypography = staticCompositionLocalOf<TrpTypography> {
    error("Wrap you content with TrpTheme {} to get access to typography")
}
private val LocalTrpColors = staticCompositionLocalOf<TrpColors> {
    error("Wrap you content with TrpTheme {} to get access to colors")
}


@Composable
fun TrpTheme(
    theme: BaseTheme,
    fontFamily: FontFamily = TrpFontFamily,
    content: @Composable () -> Unit,
) {
    val typography = TrpTypography(defaultFontFamily = fontFamily)
    val colors = theme.toTrpColors()

    CompositionLocalProvider(
        LocalTrpTypography provides typography,
        LocalTrpColors provides colors,
        LocalElevationOverlay provides null,
    ) {
        MaterialTheme(
            colors = theme.toColors(),
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

    val colors: TrpColors
        @Composable
        get() = LocalTrpColors.current

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

open class BaseTheme() {

    @Composable
    fun toColors(): Colors = toTrpColors().toMaterialColors()

    @Composable
    fun toTrpColors(): TrpColors = if (isSystemInDarkTheme())
        toDarkColors()
    else
        toLightColors()

    open fun toLightColors() = TrpColors.toLightColors()

    open fun toDarkColors() = TrpColors.toDartColors()
}