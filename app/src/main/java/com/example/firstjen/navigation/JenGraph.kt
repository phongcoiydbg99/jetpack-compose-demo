package com.example.firstjen.navigation

sealed class JenRoute(val route: String) {

    object Hotel : JenRoute("hotel")
    object FLight : JenRoute("flight")
    object Text : JenRoute("text")
    object Button : JenRoute("button")
}
