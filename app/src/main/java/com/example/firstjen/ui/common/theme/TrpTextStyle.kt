package com.example.firstjen.ui.common.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

open class TrpTextStyle constructor(
    fontFamily: FontFamily = TrpFontFamily,
    fontSize: TrpFontSize = TrpFontSize()
) {

    open val trpTextStyleH1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h1,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleH2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h2,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleH3: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h3,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleH4: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h4,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleH5: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h5,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleH6: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.h6,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleSub1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.sub1,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleSub2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.sub2,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleBody1: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.body1,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleBody2: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.body2,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleButton: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.button,
        fontWeight = FontWeight.Normal,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleCaption: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.caption,
        fontWeight = FontWeight.Light,
        letterSpacing = TrpLetterSpacing.default
    )

    open val trpTextStyleOverline: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize.overline,
        fontWeight = FontWeight.Light,
        letterSpacing = TrpLetterSpacing.default
    )
}