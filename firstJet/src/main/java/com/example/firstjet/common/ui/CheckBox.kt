package com.example.firstjet.common.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//IconToggleButton(checked = , onCheckedChange = {}) {
//    val transition = updateTransition(check, label = "")
//    val tint by transition.animateColor(label = "iconColor") { isChecked ->
//        if (isChecked) Color.Green else Color.Black
//    }
//
//    val size by transition.animateDp(
//        transitionSpec = {
//            if (false isTransitioningTo true) {
//                keyframes {
//                    durationMillis = 250
//                    30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
//                    35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
//                    40.dp at 75 // ms
//                    35.dp at 150 // ms
//                }
//            } else {
//                spring(stiffness = Spring.StiffnessVeryLow)
//            }
//        },
//        label = "Size"
//    ) { 30.dp }
//
//    Icon(
//        imageVector = if (check) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
//        contentDescription = "Icon",
//        tint = tint,
//        modifier = androidx.compose.ui.Modifier.size(size)
//    )
//}