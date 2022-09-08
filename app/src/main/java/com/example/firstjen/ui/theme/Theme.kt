package com.example.firstjen.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.firstjen.ui.common.theme.BaseTheme
import com.example.firstjen.ui.common.theme.TrpColors
import com.example.firstjen.ui.common.theme.TrpFontSize
import com.example.firstjen.ui.common.theme.TrpTextStyle

class PartnerTheme : BaseTheme() {
    override val lightColors = TrpColors.lightColors(
        primary = Color(0xFF57C478),
        primaryVariant = Color(0xFF61C27E),
        secondary = Color(0xFFFF3366),
    )

    override val darkColors = TrpColors.dartColors(
        primary = Color(0xFF2E6940),
        primaryVariant = Color(0xFF3B7A4F),
        secondary = Color(0xFFA32041),
    )
}