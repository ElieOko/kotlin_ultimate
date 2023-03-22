package com.example.custom.view.Widget.MTextField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MTextField(){

}

@Composable
fun MTextFieldBody(){
    var username by remember(){ mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value =username,
        singleLine = true,
        onValueChange ={username=it},
        shape = RoundedCornerShape(25.dp),
        label ={ Text(text="Nom d'utilisateur") },
        trailingIcon = {
            IconButton(onClick = {username}){
                Icon(imageVector =  Icons.Filled.Person,contentDescription ="")
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun MTextFieldPreview(){
    MTextFieldBody()
}