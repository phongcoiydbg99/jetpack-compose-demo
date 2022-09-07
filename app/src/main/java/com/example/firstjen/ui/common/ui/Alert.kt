package com.example.firstjen.ui.common.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.firstjen.ui.common.theme.TrpTheme

@Composable
fun TrpAlert(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    text: String? = null,
    confirm: String? = null,
    dismiss: String? = null,
    shape: Shape = TrpTheme.shapes.medium,
    backgroundColor: Color = TrpTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    properties: DialogProperties = DialogProperties()
) {
    TrpAlert(
        openDialog = openDialog,
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            title?.let { TrpText(text = it, style = TrpTheme.typography.trpTextStyleSub1) }
        },
        content = {
            text?.let { TrpText(text = it, style = TrpTheme.typography.trpTextStyleBody2) }
        },
        buttons = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                if (!confirm.isNullOrBlank()) {
                    TrpButton(
                        modifier = Modifier.weight(1f),
                        onClick = onDismissRequest,
                        text = confirm,
                        buttonType = TrpButtonType.Primary,
                        buttonStyle = TrpButtonStyle.Text,
                    )
                    if (!dismiss.isNullOrBlank()) {
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                }
                if (!dismiss.isNullOrBlank()) {
                    if (!confirm.isNullOrBlank()) {
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                    TrpButton(
                        modifier = Modifier.weight(1f),
                        onClick = onDismissRequest,
                        text = dismiss,
                        buttonType = TrpButtonType.Primary,
                        buttonStyle = TrpButtonStyle.Text
                    )
                }
            }
        },
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        properties = properties,
    )
}

@Composable
fun TrpAlert(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    content: @Composable (() -> Unit)? = null,
    buttons: @Composable () -> Unit,
    shape: Shape = TrpTheme.shapes.medium,
    backgroundColor: Color = TrpTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    properties: DialogProperties = DialogProperties()
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = properties
        ) {
            TrpAlertDialogContent(
                buttons = buttons,
                modifier = modifier,
                title = title,
                content = content,
                shape = shape,
                backgroundColor = backgroundColor,
                contentColor = contentColor
            )
        }
    }
}

@Composable
fun TrpAlertDialogContent(
    buttons: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    content: @Composable (() -> Unit)? = null,
    shape: Shape = TrpTheme.shapes.medium,
    backgroundColor: Color = TrpTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            title?.invoke()
            Spacer(modifier = Modifier.padding(4.dp))
            content?.invoke()
            Spacer(modifier = Modifier.padding(4.dp))
            buttons()
        }
    }
}
