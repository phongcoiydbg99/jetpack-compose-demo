package com.example.firstjet.common.ui

import android.graphics.Typeface
import android.text.style.*
import android.widget.TextView
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import java.io.File

private const val URL_TAG = "url_tag"
private const val PATH_SYSTEM_FONTS_FILE = "/system/etc/fonts.xml"
private const val PATH_SYSTEM_FONTS_DIR = "/system/fonts/"

@Composable
fun TrpText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit? = null,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    onListener: ((String) -> Unit)? = null,
    URLSpanStyle: SpanStyle = SpanStyle(
        color = linkTextColor(),
        textDecoration = TextDecoration.Underline
    ),
    flags: Int = HtmlCompat.FROM_HTML_MODE_COMPACT,
) {
    val content = text.toHTML(fontSize ?: style.fontSize, flags, URLSpanStyle)
    val textColor = color.takeOrElse {
        style.color.takeOrElse {
            LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        }
    }

    val mergedStyle = style.merge(
        TextStyle(
            color = textColor,
            fontSize = fontSize ?: style.fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            textDecoration = textDecoration,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing
        )
    )

    if (onListener != null) {
        ClickableText(
            modifier = modifier,
            text = content,
            style = mergedStyle,
            softWrap = softWrap,
            overflow = overflow,
            maxLines = maxLines,
            onTextLayout = onTextLayout,
            onClick = { pos ->
                content.getStringAnnotations(URL_TAG, pos, pos)
                    .firstOrNull()
                    ?.let { stringAnnotation -> onListener(stringAnnotation.item) }
            }
        )
    } else {
        Text(
            text = content,
            modifier = modifier,
            style = mergedStyle,
            softWrap = softWrap,
            overflow = overflow,
            maxLines = maxLines,
            onTextLayout = onTextLayout,
            inlineContent = inlineContent,
        )
    }
}

@Composable
fun TrpText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit? = null,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    onListener: ((String) -> Unit)? = null,
    tag: String = URL_TAG,
) {
    val textColor = color.takeOrElse {
        style.color.takeOrElse {
            LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        }
    }

    val mergedStyle = style.merge(
        TextStyle(
            color = textColor,
            fontSize = fontSize ?: style.fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            textDecoration = textDecoration,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing
        )
    )

    if (onListener != null) {
        ClickableText(
            modifier = modifier,
            text = text,
            style = mergedStyle,
            softWrap = softWrap,
            overflow = overflow,
            maxLines = maxLines,
            onTextLayout = onTextLayout,
            onClick = { pos ->
                text.getStringAnnotations(tag, pos, pos)
                    .firstOrNull()
                    ?.let { stringAnnotation -> onListener(stringAnnotation.item) }
            }
        )
    } else {
        Text(
            text = text,
            modifier = modifier,
            style = mergedStyle,
            softWrap = softWrap,
            overflow = overflow,
            maxLines = maxLines,
            onTextLayout = onTextLayout,
            inlineContent = inlineContent,
        )
    }
}

@Composable
fun linkTextColor() = Color(
    TextView(LocalContext.current).linkTextColors.defaultColor
)

@Composable
private fun String.toHTML(
    fontSize: TextUnit,
    flags: Int,
    URLSpanStyle: SpanStyle
) = buildAnnotatedString {
    val spanned = HtmlCompat.fromHtml(this@toHTML, flags)
    val spans = spanned.getSpans(0, spanned.length, Any::class.java)

    append(spanned.toString())

    spans
        .filter { it !is BulletSpan }
        .forEach { span ->
            val start = spanned.getSpanStart(span)
            val end = spanned.getSpanEnd(span)
            when (span) {
                is RelativeSizeSpan -> span.spanStyle(fontSize)
                is StyleSpan -> span.spanStyle()
                is UnderlineSpan -> span.spanStyle()
                is ForegroundColorSpan -> span.spanStyle()
                is TypefaceSpan -> span.spanStyle()
                is StrikethroughSpan -> span.spanStyle()
                is SuperscriptSpan -> span.spanStyle()
                is SubscriptSpan -> span.spanStyle()
                is URLSpan -> {
                    addStringAnnotation(
                        tag = URL_TAG,
                        annotation = span.url,
                        start = start,
                        end = end
                    )
                    URLSpanStyle
                }
                else -> {
                    null
                }
            }?.let { spanStyle ->
                addStyle(spanStyle, start, end)
            }
        }
}

internal fun UnderlineSpan.spanStyle(): SpanStyle =
    SpanStyle(textDecoration = TextDecoration.Underline)

internal fun ForegroundColorSpan.spanStyle(): SpanStyle =
    SpanStyle(color = Color(foregroundColor))

internal fun StrikethroughSpan.spanStyle(): SpanStyle =
    SpanStyle(textDecoration = TextDecoration.LineThrough)

internal fun RelativeSizeSpan.spanStyle(fontSize: TextUnit): SpanStyle =
    SpanStyle(fontSize = (fontSize.value * sizeChange).sp)

internal fun StyleSpan.spanStyle(): SpanStyle? = when (style) {
    Typeface.BOLD -> SpanStyle(fontWeight = FontWeight.Bold)
    Typeface.ITALIC -> SpanStyle(fontStyle = FontStyle.Italic)
    Typeface.BOLD_ITALIC -> SpanStyle(
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
    )
    else -> null
}

internal fun SubscriptSpan.spanStyle(): SpanStyle =
    SpanStyle(baselineShift = BaselineShift.Subscript)

internal fun SuperscriptSpan.spanStyle(): SpanStyle =
    SpanStyle(baselineShift = BaselineShift.Superscript)

internal fun TypefaceSpan.spanStyle(): SpanStyle? {
    val xmlContent = File(PATH_SYSTEM_FONTS_FILE).readText()
    return if (xmlContent.contains("""<family name="$family""")) {
        val familyChunkXml = xmlContent.substringAfter("""<family name="$family""")
            .substringBefore("""</family>""")
        val fontName = familyChunkXml.substringAfter("""<font weight="400" style="normal">""")
            .substringBefore("</font>")
        SpanStyle(fontFamily = FontFamily(Typeface.createFromFile("$PATH_SYSTEM_FONTS_DIR$fontName")))
    } else {
        null
    }
}