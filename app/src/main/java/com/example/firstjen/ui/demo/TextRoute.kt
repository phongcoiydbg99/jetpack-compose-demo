package com.example.firstjen.ui.demo

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.firstjen.R
import com.example.firstjen.navigation.JenAppState
import com.example.firstjen.navigation.JenRoute
import com.example.firstjen.ui.common.theme.TrpColor
import com.example.firstjen.ui.common.theme.TrpTheme
import com.example.firstjen.ui.common.ui.TrpText

@Composable
fun TextRoute(state: JenAppState) {
    Surface(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TextScreen(state::navigate)
    }
}

@Composable
fun TextScreen(navigate: (JenRoute) -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )  {
        TrpText(text = "Demo")
        TrpText(text = "trpTextStyleH1", style = TrpTheme.typography.trpTextStyleH1)
        TrpText(text = "trpTextStyleH2", style = TrpTheme.typography.trpTextStyleH2)
        TrpText(text = "trpTextStyleH3", style = TrpTheme.typography.trpTextStyleH3)
        TrpText(text = "trpTextStyleH4", style = TrpTheme.typography.trpTextStyleH4)
        TrpText(text = "trpTextStyleH5", style = TrpTheme.typography.trpTextStyleH5)
        TrpText(text = "trpTextStyleH6", style = TrpTheme.typography.trpTextStyleH6)
        TrpText(text = "trpTextStyleSub1", style = TrpTheme.typography.trpTextStyleSub1)
        TrpText(text = "trpTextStyleSub2", style = TrpTheme.typography.trpTextStyleSub2)
        TrpText(text = "trpTextStyleBody1", style = TrpTheme.typography.trpTextStyleBody1)
        TrpText(text = "trpTextStyleBody2", style = TrpTheme.typography.trpTextStyleBody2)
        TrpText(text = "trpTextStyleButton", style = TrpTheme.typography.trpTextStyleButton)
        TrpText(text = "trpTextStyleCaption", style = TrpTheme.typography.trpTextStyleCaption)
        TrpText(text = "trpTextStyleOverline", style = TrpTheme.typography.trpTextStyleOverline)
        TrpText(
            text = stringResource(id = R.string.ticket_and_airline_operation),
            modifier = Modifier,
            style = TrpTheme.typography.trpTextStyleSub1,
            fontStyle = FontStyle.Italic
        )
        TrpText(
            text = stringResource(
                id = R.string.message_pay_without_markup_cash,
                "1.000.000",
                "chuyển khoản"
            ),
            modifier = Modifier.padding(horizontal = 16.0.dp, vertical = 16.0.dp),
            style = TrpTheme.typography.trpTextStyleBody1,
            onListener = {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                context.startActivity(browserIntent)
            },
        )
        TrpText(
            text = buildAnnotatedString {
                append("Sample ")
                withStyle(style = SpanStyle(color = TrpColor.pink)) {
                    append("Text")
                }
                addStringAnnotation(
                    tag = "url_tag",
                    annotation = "ON CLICK LINK",
                    start = 7,
                    end = 10
                )
            },
            fontStyle = FontStyle.Italic,
            onListener = {
                Log.d("PhongNV", "HotelScreen: $it")
            }
        )
    }
}