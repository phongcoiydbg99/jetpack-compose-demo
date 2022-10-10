package com.example.firstjen.ui.demo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firstjen.R
import com.example.firstjen.navigation.JenAppState
import com.example.firstjen.navigation.JenRoute
import com.example.firstjet.common.theme.TrpColor
import com.example.firstjet.common.theme.TrpTheme
import com.example.firstjet.common.ui.*

@Composable
fun ButtonRoute(state: JenAppState) {
    Surface {
        ButtonScreen(state::navigate)
    }
}

@Composable
fun ButtonScreen(navigate: (JenRoute) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )  {
        Text(text = "Demo")
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            text = stringResource(id = R.string.flight),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = TrpColor.pink
            ),
            elevation = null,
            textColor = Color.White,
            textStyle = TrpTheme.typography.trpTextStyleSub1,
            iconStart = {
                Icon(
                    contentDescription = null,
                    imageVector = Icons.Filled.Favorite,
                    tint = TrpColor.white
                )
            }
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Default
        )
        TrpButton(
            modifier = Modifier.padding(16.dp),
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            buttonType = TrpButtonType.Secondary,
            buttonStyle = TrpButtonStyle.Outline
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            buttonType = TrpButtonType.Secondary,
            buttonStyle = TrpButtonStyle.Default,
            buttonSize = TrpButtonSize.Large
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            enabled = false,
            buttonType = TrpButtonType.Secondary,
            buttonStyle = TrpButtonStyle.Default
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            enabled = false,
            buttonType = TrpButtonType.Secondary,
            buttonStyle = TrpButtonStyle.Outline
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            text = stringResource(id = R.string.flight),
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Text
        )
        TrpButton(
            onClick = { navigate.invoke(JenRoute.FLight) },
            colors = ButtonDefaults.outlinedButtonColors(),
            elevation = null,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.trp_flight_ic_baggage),
                contentDescription = null
            )
            TrpText(text = "go to flight", style = TrpTheme.typography.trpTextStyleBody1)
        }
    }
}