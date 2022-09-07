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
        Alert()
        var check by remember { mutableStateOf<Boolean>(false) }
        Checkbox(checked = check, onCheckedChange = { check = it })
        IconToggleButton(checked = check, onCheckedChange = {
            check = it
        }) {
            // on below line we are creating a
            // variable for our transition
            val transition = updateTransition(check, label = "")

            // on below line we are creating a variable for
            // color of our icon
            val tint by transition.animateColor(label = "iconColor") { isChecked ->
                // if toggle button is checked we are setting color as red.
                // in else condition we are setting color as black
                if (isChecked) Color.Green else Color.Black
            }

            // om below line we are specifying transition
            val size by transition.animateDp(
                transitionSpec = {
                    // on below line we are specifying transition
                    if (false isTransitioningTo true) {
                        // on below line we are specifying key frames
                        keyframes {
                            // on below line we are specifying animation duration
                            durationMillis = 250
                            // on below line we are specifying animations.
                            30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                            35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                            90.dp at 75 // ms
                            35.dp at 150 // ms
                        }
                    } else {
                        spring(stiffness = Spring.StiffnessVeryLow)
                    }
                },
                label = "Size"
            ) { 30.dp }

            // on below line we are creating icon for our toggle button.
            Icon(
                // on below line we are specifying icon for our image vector.
                imageVector = if (check) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Icon",
                // on below line we are specifying
                // tint for our icon.
                tint = tint,
                // on below line we are specifying
                // size for our icon.
                modifier = Modifier.size(size)
            )
        }
    }
}

@Composable
fun Alert() {
    Column {
        val openDialog = remember { mutableStateOf(false) }
        Button(onClick = {
            openDialog.value = true
        }) {
            Text("Click me")
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Dialog Title")
                },
                text = {
                    Text("Here is a text ")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the Confirm Button")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the dismiss Button")
                    }
                }
            )
        }
    }
}