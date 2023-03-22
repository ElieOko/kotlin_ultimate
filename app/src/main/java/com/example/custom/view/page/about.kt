package com.example.custom.view.page

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.custom.R
import com.example.custom.view.Widget.TopBar.CTopBar

@Composable
fun About(){
//Divider(color = Color.Blue, thickness = 1.dp)
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutBody(){
    Scaffold(topBar = {
        CTopBar("A propos")
    }, backgroundColor = Color.DarkGray){
        Column() {
            //Bloc1
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Andy Rubin",
                    modifier = Modifier.width(94.dp)
                )
                Column{
                    Text(text = "Magic Tech,SARL", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Av Couteau n°29, C/Gombe Kinshasa")
                    Text("Congo Republique Democratique")
                }
            }
            Spacer(modifier = Modifier.height(3.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            //Bloc2
                Column(){
                    Row(){
                        Icon(Icons.Filled.Info, null)
                        Column(){
                            Text("PESA SANGO", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = Color.White, modifier = Modifier.padding(start =14.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text("Partager des informations sur divers évenements, à proximité.")
                    Text("Vous êtes en mésure d'informer toute la communauté par\nimages,vidéos,commentaires.")
                    Text("Et grâce aux données de localisation, vous pouvez consulter la carte et être toujours informés.")
                }

            Divider(color = Color.Black, thickness = 1.dp)
            //Bloc3
            Row() {
                Icon(Icons.Filled.Devices, null)
                Column(){
                    Text("pesasango.com", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = Color.Blue)
                }
            }
            Row() {
                Icon(Icons.Filled.Mail, null)
                Column() {
                    Text("Nous écrire avec cette adresse email")
                    Text("support@magic-tech.net",color = Color.Blue)
                }
            }
        }
    }
}
@Composable
@Preview
fun AboutPreview(){
    AboutBody()
}