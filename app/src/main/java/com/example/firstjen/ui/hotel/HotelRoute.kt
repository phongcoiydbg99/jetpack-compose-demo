package com.example.firstjen.ui.hotel

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.firstjen.navigation.JenAppState
import com.example.firstjen.navigation.JenRoute
import com.example.firstjen.ui.common.theme.TrpColor
import com.example.firstjen.ui.common.theme.TrpTheme
import com.example.firstjen.ui.common.ui.*


@Composable
fun HotelRoute(state: JenAppState) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            state.navigateUp()
                        },
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Icon",
                )

                TrpText(
                    modifier = Modifier.weight(1f),
                    text = "Demo",
                    style = TrpTheme.typography.trpTextStyleH4
                )

                Icon(
                    modifier = Modifier.padding(8.dp),
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Icon",
                )
                Icon(
                    modifier = Modifier.padding(8.dp),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Icon",
                )
            }
        }
    ) {
        HotelScreen(state = state)
    }
}

@Composable
fun HotelScreen(state: JenAppState) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }
    var open by remember { mutableStateOf<Boolean>(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TrpButton(
            onClick = { state.navigate(JenRoute.Text) },
            text = "Text",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Default
        )
        TrpButton(
            onClick = { state.navigate(JenRoute.Button) },
            text = "Button",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )
        TrpButton(
            onClick = { open = true },
            text = "Alert",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )

        TrpButton(
            onClick = { openDialog.value = true },
            text = "Alert ",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )


        TrpAlert(openDialog = open, onDismissRequest = { open = false }, title = "Alert", text = "500 Bros", confirm = "Ok", dismiss = "Cancel", backgroundColor = TrpColor.pink)

        TrpAlert(
            openDialog = openDialog.value,
            modifier = Modifier,
            onDismissRequest = { openDialog.value = false },
            title = {
                TrpText(text = "Alert", style = TrpTheme.typography.trpTextStyleH1)
            },
            content = {
                TrpText(text = "500 bros")
            },
            buttons = {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TrpButton(
                        modifier = Modifier.weight(1f),
                        onClick = { openDialog.value = false },
                        text = "Cancel",
                        buttonType = TrpButtonType.Primary,
                        buttonStyle = TrpButtonStyle.Text
                    )
                    TrpButton(
                        modifier = Modifier.weight(1f),
                        onClick = { openDialog.value = false },
                        text = "Ok",
                        buttonType = TrpButtonType.Primary,
                        buttonStyle = TrpButtonStyle.Text
                    )
                }
            }
        )
    }
}

