package com.example.firstjen.ui.mytour

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.firstjen.navigation.JenAppState
import com.example.firstjen.navigation.JenRoute

@Composable
fun FlightRoute(state: JenAppState) {
    Surface {
        FlightScreen(state::navigate)
    }
}

@Composable
fun FlightScreen(navigate: (JenRoute) -> Unit) {
    Column {
        Text(text = "FLight")
        Button(onClick = {navigate.invoke(JenRoute.Hotel)}) {
            Text(text = "go to hotel")
        }
    }
}