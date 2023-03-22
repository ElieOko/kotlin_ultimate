package com.example.custom.view.Widget.TopBar

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CTopBar(title:String){
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text =title)
        },
        backgroundColor =  Color.DarkGray,
        navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Mail, null)
            }
        })
}
@Composable
fun CTopBarBody(){

}
@Composable
@Preview
fun CTopBarPreview(){
    CTopBar("A propos")
}
