package com.example.custom.view.page

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle


@Composable
fun Hyper(){
    val text = "Cliquez sur ce lien pour aller sur example.com."
    val url = "https://www.example.com"
    val annotatedText: AnnotatedString = buildAnnotatedString {
        append(text)
        withStyle(SpanStyle(color = Color.Green)) {
            // green text style will be applied to all text in this block
            append(text)
        }
        withStyle(SpanStyle(color = Color.Red)) {
            // green text style will be applied to all text in this block
            append(url)
        }

    }
}


fun extractHyperlink(input: String): String? {
    val regex = Regex("""(https?|ftp)://[^\s/$.?#].[^\s]*""")
    val matchResult = regex.find(input)
    return matchResult?.value
}

fun main(){
    val input = "Voici un lien hypertexte : https://example.com"
    val hyperlink = extractHyperlink(input)
    if (hyperlink != null) {
        println("Le lien hypertexte trouvé est : $hyperlink")
    } else {
        println("Aucun lien hypertexte trouvé dans la chaîne.")
    }
}