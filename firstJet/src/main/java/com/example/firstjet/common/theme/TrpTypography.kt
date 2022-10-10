package com.example.firstjet.common.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

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
    val trpTextStyleOverline: TextStyle,
) {

    internal constructor(
        textStyle: TrpTextStyle = TrpTextStyle(),
    ) : this(
        trpTextStyleH1 = textStyle.trpTextStyleH1,
        trpTextStyleH2 = textStyle.trpTextStyleH2,
        trpTextStyleH3 = textStyle.trpTextStyleH3,
        trpTextStyleH4 = textStyle.trpTextStyleH4,
        trpTextStyleH5 = textStyle.trpTextStyleH5,
        trpTextStyleH6 = textStyle.trpTextStyleH6,
        trpTextStyleSub1 = textStyle.trpTextStyleSub1,
        trpTextStyleSub2 = textStyle.trpTextStyleSub2,
        trpTextStyleBody1 = textStyle.trpTextStyleBody1,
        trpTextStyleBody2 = textStyle.trpTextStyleBody2,
        trpTextStyleCaption = textStyle.trpTextStyleCaption,
        trpTextStyleButton = textStyle.trpTextStyleButton,
        trpTextStyleOverline = textStyle.trpTextStyleOverline,
    )
}

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