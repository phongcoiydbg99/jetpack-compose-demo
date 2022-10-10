package com.example.firstjet.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.firstjet.common.theme.TrpColor
import com.example.firstjet.common.theme.TrpTheme
import com.example.firstjet.common.ui.TrpRadius.Companion.toShape

class TrpBorder(
    val color: Color = TrpColor.neutral_300,
    val width: Dp = 0.dp,
    val dash: Boolean = false,
    val dashWidth: Dp = 0.dp
)

class TrpRadius(
    val topStart: Dp = 0.dp,
    val topEnd: Dp = 0.dp,
    val bottomEnd: Dp = 0.dp,
    val bottomStart: Dp = 0.dp
) {
    companion object {
        fun toRadius(radius: Dp = 0.dp) = TrpRadius(radius, radius, radius, radius)
        fun toRadius(topRadius: Dp = 0.dp, bottomRadius: Dp = 0.dp) =
            TrpRadius(topRadius, topRadius, bottomRadius, bottomRadius)

        fun toRadius(
            topStart: Dp = 0.dp,
            topEnd: Dp = 0.dp,
            bottomEnd: Dp = 0.dp,
            bottomStart: Dp = 0.dp
        ) = TrpRadius(
            topStart,
            topEnd,
            bottomEnd,
            bottomStart
        )

        fun TrpRadius.toShape() = RoundedCornerShape(
            topStart,
            topEnd,
            bottomEnd,
            bottomStart
        )
    }
}

@Composable
fun TrpCard(
    modifier: Modifier,
    radius: TrpRadius = TrpRadius(),
    backgroundColor: Color = TrpTheme.colors.background,
    elevation: Dp = 0.dp,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val shape = radius.toShape()
    Surface(modifier = modifier
        .clip(shape)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = true),
        ) {
            onClick?.invoke()
        },
        color = backgroundColor,
        elevation = elevation,
        shape = shape,
        border = border
    ) {
        content()
    }
}