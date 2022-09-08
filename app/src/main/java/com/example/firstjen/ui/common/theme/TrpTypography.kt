package com.example.firstjen.ui.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

@Immutable
class TrpTypography internal constructor(
    val trpTextStyleH1: TextStyle,
    val trpTextStyleH2: TextStyle,
    val trpTextStyleH3: TextStyle,
    val trpTextStyleH4: TextStyle,
    val trpTextStyleH5: TextStyle,
    val trpTextStyleH6: TextStyle,
    val trpTextStyleSub1: TextStyle,
    val trpTextStyleSub2: TextStyle,
    val trpTextStyleBody1: TextStyle,
    val trpTextStyleBody2: TextStyle,
    val trpTextStyleButton: TextStyle,
    val trpTextStyleCaption: TextStyle,
    val trpTextStyleOverline: TextStyle
) {
    internal constructor(
        defaultFontFamily: FontFamily = TrpFontFamily,
        trpTextStyleH1: TextStyle = TextStyle(
            fontSize = TrpFontSize.h1,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleH2: TextStyle = TextStyle(
            fontSize = TrpFontSize.h2,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleH3: TextStyle = TextStyle(
            fontSize = TrpFontSize.h3,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleH4: TextStyle = TextStyle(
            fontSize = TrpFontSize.h4,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleH5: TextStyle = TextStyle(
            fontSize = TrpFontSize.h5,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleH6: TextStyle = TextStyle(
            fontSize = TrpFontSize.h6,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleSub1: TextStyle = TextStyle(
            fontSize = TrpFontSize.sub1,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleSub2: TextStyle = TextStyle(
            fontSize = TrpFontSize.sub2,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleBody1: TextStyle = TextStyle(
            fontSize = TrpFontSize.body1,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleBody2: TextStyle = TextStyle(
            fontSize = TrpFontSize.body2,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleButton: TextStyle = TextStyle(
            fontSize = TrpFontSize.button,
            fontWeight = FontWeight.Normal,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleCaption: TextStyle = TextStyle(
            fontSize = TrpFontSize.caption,
            fontWeight = FontWeight.Light,
            letterSpacing = TrpLetterSpacing.default
        ),
        trpTextStyleOverline: TextStyle = TextStyle(
            fontSize = TrpFontSize.overline,
            fontWeight = FontWeight.Light,
            letterSpacing = TrpLetterSpacing.default
        ),
    ) : this(
        trpTextStyleH1 = trpTextStyleH1.withTrpFontFamily(defaultFontFamily),
        trpTextStyleH2 = trpTextStyleH2.withTrpFontFamily(defaultFontFamily),
        trpTextStyleH3 = trpTextStyleH3.withTrpFontFamily(defaultFontFamily),
        trpTextStyleH4 = trpTextStyleH4.withTrpFontFamily(defaultFontFamily),
        trpTextStyleH5 = trpTextStyleH5.withTrpFontFamily(defaultFontFamily),
        trpTextStyleH6 = trpTextStyleH6.withTrpFontFamily(defaultFontFamily),
        trpTextStyleSub1 = trpTextStyleSub1.withTrpFontFamily(defaultFontFamily),
        trpTextStyleSub2 = trpTextStyleSub2.withTrpFontFamily(defaultFontFamily),
        trpTextStyleBody1 = trpTextStyleBody1.withTrpFontFamily(defaultFontFamily),
        trpTextStyleBody2 = trpTextStyleBody2.withTrpFontFamily(defaultFontFamily),
        trpTextStyleCaption = trpTextStyleCaption.withTrpFontFamily(defaultFontFamily),
        trpTextStyleButton = trpTextStyleButton.withTrpFontFamily(defaultFontFamily),
        trpTextStyleOverline = trpTextStyleOverline.withTrpFontFamily(defaultFontFamily),

    )
}

private fun TextStyle.withTrpFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}