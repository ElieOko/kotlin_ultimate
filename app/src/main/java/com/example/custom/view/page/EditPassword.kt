package com.example.custom.view.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.custom.view.Widget.TopBar.CTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditPassword(){
    var password by remember(){
        mutableStateOf("")
    }
    var isPasswordVisible by remember(){
        mutableStateOf(false)
    }
    Scaffold(topBar ={
        CTopBar(title = "Modifier mot de passe")
    }, backgroundColor =    Color.DarkGray ) {
        Column() {
            Spacer(modifier = Modifier.height(23.dp))
            Text(text = "Votre ancien mot de passe",fontSize = 15.sp, fontWeight = FontWeight.Bold,modifier = Modifier
                .padding(start = 27.dp))
            Row() {
                Icon(imageVector =Icons.Default.Security,contentDescription ="",modifier = Modifier
                    .size(34.dp)
                )
                OutlinedTextField(

                    value =password,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange ={password=it},
                    singleLine = true,
                    label ={ Text(text="Ancien") },
                    trailingIcon = {
                        IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                            Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")

                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Votre nouveau mot de passe",fontSize = 15.sp, fontWeight = FontWeight.Bold,modifier = Modifier
                .padding(start = 27.dp))
            Row() {
                Icon(imageVector =Icons.Default.Security,contentDescription ="",modifier = Modifier
                    .size(34.dp)
                   )
                OutlinedTextField(

                    value =password,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange ={password=it},
                    singleLine = true,
                    label ={ Text(text="Nouveau") },
                    trailingIcon = {
                        IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                            Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Confirmer nouveau mot de passe",fontSize = 15.sp, fontWeight = FontWeight.Bold,modifier = Modifier
                .padding(start = 27.dp))
            Row() {
                Icon(imageVector =Icons.Default.Check,contentDescription ="",modifier = Modifier
                    .size(34.dp))
                OutlinedTextField(
                    value =password,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange ={password=it},
                    singleLine = true,
                    label ={ Text(text="Confirmer") },
                    trailingIcon = {
                        IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                            Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")
                        }
                    }
                )
            }

        }
    }
}
@Composable
@Preview
fun EditPasswordPreview(){
    EditPassword()
}