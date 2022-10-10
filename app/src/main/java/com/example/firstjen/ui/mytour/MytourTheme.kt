package com.example.firstjen.ui.mytour

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.firstjet.common.theme.BaseTheme
import com.example.firstjet.common.theme.TrpColors

class MytourTheme : BaseTheme() {

    override val fontSize: MytourFontSize
        get() = MytourFontSize()

    override val fontFamily: FontFamily
        get() = super.fontFamily

    override val textStyle: MytourTextStyle
        get() = MytourTextStyle(fontFamily, fontSize)

    override val lightColors = TrpColors.lightColors(
        primary = Color(0xFFFF3366),
        primaryVariant = Color(0xFFFF4171),
        secondary = Color(0xFFFF9233),
    )

    override val darkColors = TrpColors.dartColors(
        primary = Color(0xFF831A34),
        primaryVariant = Color(0xFF9B2744),
        secondary = Color(0xFF693C15),
    )

}