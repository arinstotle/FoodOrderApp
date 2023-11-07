package com.example.nonameapp.ui.signUp.tinyComposableElements

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.*
import com.example.nonameapp.ui.theme.ReemKufi
import com.example.nonameapp.R

@Composable
fun OrdinaryTextComponent(content : String,
                          size : Int = 20,
                          fontWeight: FontWeight = FontWeight.Normal,
                          heightMin : Int = 40,
                          topPadding : Int = 0,
                          color : Color = Color.Black
) {
    Text(
        text = content,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = heightMin.dp)
            .padding(start = 16.dp, end = 16.dp, top = topPadding.dp),
        style = TextStyle(
            fontFamily = ReemKufi,
            fontSize = size.sp,
            fontWeight = fontWeight
        ),
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun TermTextComponent(onTextSelected : (String, String, String) -> Unit = { s: String, s1: String, s2: String ->
                      }) {
    val startedTermText = stringResource(id = R.string.terms_start)
    val privacyPolicy = stringResource(id = R.string.privacy_policy)
    val termsAnd = stringResource(id = R.string.terms_and)
    val termOfUse = stringResource(id = R.string.term_of_use)

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = Color.White,
            fontFamily = ReemKufi
        )) {
            append(startedTermText)
        }
        append(" ")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline,
            fontFamily = ReemKufi
        )) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        append(" ")
        withStyle(style = SpanStyle(
            fontFamily = ReemKufi,
            color = Color.White
        )) {
            append(termsAnd)
        }
        append(" ")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline,
            fontFamily = ReemKufi
        )) {
            pushStringAnnotation(tag = termOfUse, annotation = termOfUse)
            append(termOfUse)
        }
    }
    ClickableText(modifier = Modifier.padding(16.dp), text = annotatedString, onClick = {
        offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { text ->
                if (text.item == privacyPolicy || text.item == termOfUse) {
                    onTextSelected(privacyPolicy, termOfUse, text.item)
                }
            }
    })
}

@Composable
fun ToLoginTextComponent(onTextSelected : () -> Unit = {
    Log.d("tag", "Message")
}) {
    val startedText = stringResource(id = R.string.already_have_account)
    val loginText = stringResource(id = R.string.login)

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontFamily = ReemKufi,
            color = Color.White
        )) {
            append(startedText)
        }
        append(" ")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline,
            fontFamily = ReemKufi
        )) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        text = annotatedString,
        style = TextStyle(
            fontFamily = ReemKufi,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = {
            offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { text ->
                if (text.item == loginText) {
                    onTextSelected()
                }
            }
    })
}

@Composable
fun ToRegisterTextComponent(onTextSelected : () -> Unit = {
    Log.d("tag", "Message")
}) {
    val startedText = stringResource(id = R.string.do_not_have_account)
    val register = stringResource(id = R.string.to_register)

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontFamily = ReemKufi,
            color = Color.White
        )) {
            append(startedText)
        }
        append(" ")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline,
            fontFamily = ReemKufi
        )) {
            pushStringAnnotation(tag = register, annotation = register)
            append(register)
        }
    }
    ClickableText(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        text = annotatedString,
        style = TextStyle(
            fontFamily = ReemKufi,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = {
                offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { text ->
                    if (text.item == register) {
                        onTextSelected()
                    }
                }
        })
}