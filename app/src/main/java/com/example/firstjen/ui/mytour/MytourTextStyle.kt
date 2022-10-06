package com.example.firstjen.ui.mytour

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.firstjen.ui.common.theme.TrpFontFamily
import com.example.firstjen.ui.common.theme.TrpFontSize
import com.example.firstjen.ui.common.theme.TrpLetterSpacing
import com.example.firstjen.ui.common.theme.TrpTextStyle

class MytourTextStyle(fontFamily: FontFamily, fontSize: MytourFontSize) : TrpTextStyle(fontFamily, fontSize) {

    override val trpTextStyleH1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h1,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleH2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h2,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleH3: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h3,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleH4: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h4,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleH5: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h5,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleH6: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h6,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleSub1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.sub1,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleSub2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.sub2,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleBody1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.body1,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleBody2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.body2,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleButton: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.button,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleCaption: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.caption,
        fontWeight = FontWeight.Light,
        letterSpacing = TrpLetterSpacing.medium
    )

    override val trpTextStyleOverline: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.overline,
        fontWeight = FontWeight.Light,
        letterSpacing = TrpLetterSpacing.medium
    )
}