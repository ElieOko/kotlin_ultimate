package com.example.custom.view.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.custom.R

@Composable
fun Login(){
    val navCtrl = rememberNavController()
    LoginBody(navCtrl)
}

@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginBody(navCtrl: NavHostController){
    var phone by remember(){
        mutableStateOf("")
    }
    var password by remember(){
        mutableStateOf("")
    }
    var isPasswordVisible by remember(){
        mutableStateOf(false)
    }

    val isFormValid by derivedStateOf {
        phone.isNotBlank() && password.length > 7
    }

    Scaffold(backgroundColor = Color.White) {
        Column(  modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Image(painter = painterResource(id = R.drawable.head), contentDescription ="App Logo" ,
                modifier= Modifier
                   .weight(1f)
                   .size(42.dp),
                colorFilter = ColorFilter.tint(Color.White)
           )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                /* Modifier
                     .weight(2f)
                     .padding(8.dp),
                 shape = RoundedCornerShape(32.dp)*/
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(390.dp),
                elevation = 0.dp,

            ){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)){
                    Text(text="Inscription",fontWeight = FontWeight.Bold, color = Color.DarkGray)
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        Spacer(modifier = Modifier.weight(1f))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value =phone,
                            singleLine = true,
                            onValueChange ={phone=it},
                            label ={ Text(text="Numéro téléphone") },
                            trailingIcon = {
                                IconButton(onClick = {phone}){
                                    Icon(imageVector =  Icons.Filled.Phone,contentDescription ="")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value =password,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            onValueChange ={password=it},
                            singleLine = true,
                            label ={ Text(text="Mot de passe") },
                            trailingIcon = {
                                IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                                    Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick={
                              //  navCtrl.navigate(MyRoute.home.name)
                            },
                            enabled = isFormValid,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(26.dp)
                        ){
                            Text(text="Se connecter")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                            Text("Pas de compte ?")
                        Spacer(modifier = Modifier.weight(1f))
                        Row(){
                            Divider(color = Color.Blue, thickness = 1.dp,modifier = Modifier.width(80.dp))
                            Text("Ou")
                            Divider(color = Color.Blue, thickness = 1.dp,modifier = Modifier.width(80.dp))
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Créer un compte")
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Mot de passe oublié", color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun LoginPreview(){
    val navCtrl = rememberNavController()
    LoginBody(navCtrl)
}