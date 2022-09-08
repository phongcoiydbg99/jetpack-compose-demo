package com.example.firstjen.ui.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
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
    content: @Composable () -> Unit,
) {
    val typography = theme.trpTypography()
    val colors = theme.trpColors()

    CompositionLocalProvider(
        LocalTrpTypography provides typography,
        LocalTrpColors provides colors,
        LocalElevationOverlay provides null,
    ) {
        MaterialTheme(
            colors = theme.colors(),
            typography = theme.typography(),
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
        get() = LocalTrpTypography.current

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

open class BaseTheme {

    open val lightColors = TrpColors.lightColors()

    open val darkColors = TrpColors.dartColors()

    open val fontFamily : FontFamily
        get() = TrpFontFamily

    open val fontSize : TrpFontSize
        get() = TrpFontSize()

    open val textStyle : TrpTextStyle
        get() = TrpTextStyle(fontFamily, fontSize)

    @Composable
    fun colors(): Colors = trpColors().toMaterialColors()

    @Composable
    fun trpColors(): TrpColors = if (isSystemInDarkTheme())
        darkColors
    else
        lightColors

    fun typography(): Typography = trpTypography().toMaterialTypography(fontFamily)

    fun trpTypography() = TrpTypography(textStyle)
}