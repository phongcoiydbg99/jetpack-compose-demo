package com.example.firstjen.ui.hotel

import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.firstjen.navigation.JenAppState
import com.example.firstjen.navigation.JenRoute
import com.example.firstjen.ui.common.theme.TrpColor
import com.example.firstjen.ui.common.theme.TrpTheme
import com.example.firstjen.ui.common.ui.*


@Composable
fun HotelRoute(state: JenAppState) {
    val activity = (LocalContext.current as? ComponentActivity)
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            activity?.finish()
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
    var text by remember { mutableStateOf<String>("") }
    var error by remember { mutableStateOf<Boolean>(false) }

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
            onClick = {
                open = true
                error = !error
            },
            text = "Alert",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )

        TrpButton(
            onClick = {
                openDialog.value = true
            },
            text = "Alert ",
            buttonType = TrpButtonType.Primary,
            buttonStyle = TrpButtonStyle.Outline
        )


        TrpAlert(
            openDialog = open,
            onDismissRequest = {
                open = false
            },
            title = "Alert",
            text = "500 Bros",
            confirm = "Ok",
            dismiss = "Cancel",
            backgroundColor = TrpTheme.colors.primary
        )

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

        TextField(value = text, modifier = Modifier.padding(8.dp), onValueChange = {
            text = it
        }, isError = error, leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Icon",
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false), // You can also change the color and radius of the ripple
                    onClick = {
                        open = true
                    }
                )
            )
        }, placeholder = {
            TrpText(text = "500 bros")
        }, trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Icon",
            )
        }, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = TrpTheme.colors.surface
        )
        )

        OutlinedTextField(
            value = text, modifier = Modifier.padding(8.dp),
            onValueChange = {
                text = it
            },
            isError = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Icon",
                )
            },
            placeholder = {
                TrpText(text = "500 bros")
            },
            shape = TrpTheme.shapes.small,
        )

        Checkbox(checked = true, onCheckedChange = {})
        Checkbox(checked = false, onCheckedChange = {})

        TrpCard(
            modifier = Modifier,
            backgroundColor = TrpColor.pink,
            radius = TrpRadius.toRadius(20.dp, 20.dp, 20.dp, 20.dp),
            border = BorderStroke(4.dp, TrpColor.neutral_400),
            elevation = 50.dp
        ) {
            TrpText(
                text = "Demo",
                modifier = Modifier.padding(start = 32.dp, top = 64.dp, end = 32.dp, bottom = 64.dp)
            )
        }

    }
}

