package com.example.firstjen.ui.common.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

class TrpColors(
    val primary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val background: Color,
    val surface: Color,
    val error: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onError: Color,
    val isLight: Boolean
) {
    companion object {
        fun toLightColors(
            primary: Color = Color(0xFF6200EE),
            primaryVariant: Color = Color(0xFF3700B3),
            secondary: Color = Color(0xFF03DAC6),
            secondaryVariant: Color = Color(0xFF018786),
            background: Color = Color.White,
            surface: Color = Color.White,
            error: Color = Color(0xFFB00020),
            onPrimary: Color = Color.White,
            onSecondary: Color = Color.Black,
            onBackground: Color = Color.Black,
            onSurface: Color = Color.Black,
            onError: Color = Color.White
        ) = TrpColors(
            primary,
            primaryVariant,
            secondary,
            secondaryVariant,
            background,
            surface,
            error,
            onPrimary,
            onSecondary,
            onBackground,
            onSurface,
            onError,
            true
        )

        fun toDartColors(
            primary: Color = Color(0xFFBB86FC),
            primaryVariant: Color = Color(0xFF3700B3),
            secondary: Color = Color(0xFF03DAC6),
            secondaryVariant: Color = secondary,
            background: Color = Color(0xFF121212),
            surface: Color = Color(0xFF121212),
            error: Color = Color(0xFFCF6679),
            onPrimary: Color = Color.Black,
            onSecondary: Color = Color.Black,
            onBackground: Color = Color.White,
            onSurface: Color = Color.White,
            onError: Color = Color.Black
        ) = TrpColors(
            primary,
            primaryVariant,
            secondary,
            secondaryVariant,
            background,
            surface,
            error,
            onPrimary,
            onSecondary,
            onBackground,
            onSurface,
            onError,
            false
        )

        fun TrpColors.toMaterialColors() = Colors(
            primary,
            primaryVariant,
            secondary,
            secondaryVariant,
            background,
            surface,
            error,
            onPrimary,
            onSecondary,
            onBackground,
            onSurface,
            onError,
            isLight
        )
    }
}