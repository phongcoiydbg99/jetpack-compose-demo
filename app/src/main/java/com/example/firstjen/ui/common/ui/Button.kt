package com.example.firstjen.ui.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import com.example.firstjen.ui.common.theme.TrpColor
import com.example.firstjen.ui.common.theme.TrpTheme

enum class TrpButtonSize {
    Default,
    Large
}

enum class TrpButtonType {
    Primary,
    Secondary
}

enum class TrpButtonStyle {
    Default,
    Outline,
    Text;
}

class TrpButton(
    private val buttonType: TrpButtonType = TrpButtonType.Primary,
    private val buttonStyle: TrpButtonStyle  = TrpButtonStyle.Default,
    private val buttonSize: TrpButtonSize = TrpButtonSize.Default,
    private val enabled: Boolean = true,
) {

    @Composable
    fun toColors(): ButtonColors {
        return ButtonDefaults.buttonColors(
            backgroundColor = getBackgroundColor(),
            contentColor = getContentColor(),
            disabledBackgroundColor = getDisabledBackgroundColor(),
            disabledContentColor = getDisabledContentColor()
        )
    }

    @Composable
    fun toTextStyle(): TextStyle {
        return when(this.buttonSize) {
            TrpButtonSize.Default -> TrpTheme.typography.trpTextStyleSub1
            TrpButtonSize.Large -> TrpTheme.typography.trpTextStyleH5
        }
    }

    @Composable
    fun toContentPadding(): PaddingValues {
        return when(this.buttonSize) {
            TrpButtonSize.Default -> PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
            TrpButtonSize.Large -> PaddingValues(
                start = 30.dp,
                top = 22.dp,
                end = 30.dp,
                bottom = 22.dp
            )
        }
    }

    @Composable
    fun getBackgroundColor(): Color {
        return when (this.buttonStyle) {
            TrpButtonStyle.Outline -> TrpTheme.colors.surface
            TrpButtonStyle.Text -> TrpTheme.colors.surface
            else -> getBackgroundColorWithType()
        }
    }

    @Composable
    fun toBorder(): BorderStroke? {
        return when (this.buttonStyle) {
            TrpButtonStyle.Outline -> BorderStroke(1.dp, getBorderColor())
            else -> null
        }
    }

    @Composable
    fun getDisabledContentColor(): Color {
        return TrpColor.neutral_300
    }

    @Composable
    fun getDisabledBackgroundColor(): Color {
        return when (this.buttonStyle) {
            TrpButtonStyle.Outline -> TrpTheme.colors.surface
            TrpButtonStyle.Text -> TrpTheme.colors.surface
            else -> TrpColor.neutral_400
        }
    }

    @Composable
    fun getContentColor(): Color {
        return when (this.buttonStyle) {
            TrpButtonStyle.Outline -> getColorDarkOrLight(Color.White, Color.Black)
            TrpButtonStyle.Text -> getColorDarkOrLight(Color.White, Color.Black)
            else -> getContentColorWithType()
        }
    }

    @Composable
    fun getContentColorWithType(): Color {
        return when (this.buttonType) {
            TrpButtonType.Primary -> Color.White
            TrpButtonType.Secondary -> getColorDarkOrLight(Color.White, Color.Black)
        }
    }

    @Composable
    fun getColorDarkOrLight(dark: Color, light: Color): Color {
        return if (isSystemInDarkTheme()) dark else light
    }

    @Composable
    fun getBackgroundColorWithType(): Color {
        return when (this.buttonType) {
            TrpButtonType.Primary -> TrpTheme.colors.primary
            TrpButtonType.Secondary -> TrpTheme.colors.secondary
        }
    }

    @Composable
    private fun getBorderColor(): Color {
        return if (enabled) getBackgroundColorWithType()
        else TrpColor.neutral_400
    }
}

@Composable
fun TrpButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    buttonType: TrpButtonType,
    buttonStyle: TrpButtonStyle,
    buttonSize: TrpButtonSize = TrpButtonSize.Default,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val trpButton = TrpButton(buttonType, buttonStyle, buttonSize, enabled)
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = null,
        shape = TrpTheme.shapes.small,
        border = trpButton.toBorder(),
        colors = trpButton.toColors(),
        contentPadding = trpButton.toContentPadding(),
    ) {
        TrpText(text = text, style = trpButton.toTextStyle())
    }
}

@Composable
fun TrpButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun TrpButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = Color.Unspecified,
    textStyle: TextStyle = LocalTextStyle.current,
    flags: Int = HtmlCompat.FROM_HTML_MODE_COMPACT,
    iconStart: (@Composable () -> Unit)? = null,
    iconEnd: (@Composable () -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
    ) {
        iconStart?.let {
            iconStart.invoke()
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }

        TrpText(text = text, style = textStyle, color = textColor, flags = flags)

        iconEnd?.let {
            iconEnd.invoke()
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
    }
}