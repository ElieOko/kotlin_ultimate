package com.example.custom.view.Widget.BottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.custom.utils.Article

@Composable
@Preview
fun BottomSheetContent(){
    val x = "Termes et Conditions"
    val listArticle = Article.getData()
    Surface(
        modifier = Modifier.height(300.dp),
        color = Color(0xff9c7ca5)
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$x", fontSize = 20.sp, modifier = Modifier.padding(10.dp),
                color = Color.White, fontWeight = FontWeight.ExtraBold)
            Divider(modifier = Modifier.padding(5.dp), color = Color.White)
            LazyColumn {
                items(listArticle) {
                    Text(text = "${it.article}")
                    Text(text = "${it.desc}",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp))
                }
            }

        }
    }
}
