package com.example.firstjen.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstjen.ui.common.theme.TrpTheme
import com.example.firstjen.ui.demo.ButtonRoute
import com.example.firstjen.ui.demo.TextRoute
import com.example.firstjen.ui.flight.FlightRoute
import com.example.firstjen.ui.hotel.HotelRoute

@Composable
fun JenApp() {
    TrpTheme {
        val jenState = rememberJenAppState()
        Scaffold {
            JenNavigation(
                navController = jenState.navController,
                navigate = jenState
            )
        }
    }
}

@Composable
fun rememberJenAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    JenAppState(navController)
}

@Stable
class JenAppState(
    var navController: NavHostController
) {
    fun navigate(route: JenRoute) {
        navController.navigate(route.route)
    }

    fun navigateUp() {
        navController.navigateUp()
    }

}

@Composable
fun JenNavigation(
    navController: NavHostController = rememberNavController(),
    navigate: JenAppState
) {
    NavHost(
        navController = navController,
        startDestination = JenRoute.Hotel.route
    ) {
        composable(JenRoute.Hotel.route) {
            HotelRoute(navigate)
        }
        composable(JenRoute.FLight.route) {
            FlightRoute(navigate)
        }
        composable(JenRoute.Text.route) {
            TextRoute(navigate)
        }
        composable(JenRoute.Button.route) {
            ButtonRoute(navigate)
        }
    }
}