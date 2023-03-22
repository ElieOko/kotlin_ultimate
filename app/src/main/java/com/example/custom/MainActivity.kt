package com.example.custom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custom.view.Widget.MSelectField.MSelectFieldBody
import com.example.custom.ui.theme.CustomTheme
import com.example.custom.view.page.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //AuthenticationForm()
                    //EditProfil()
                    //UserProfile()
                    Otp()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name !")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomTheme {
        Login()
    }
}
@Composable
fun IconOneLineText(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(Icons.Default.Person, contentDescription = "Utilisateur")
        Text("Utilisateur")
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun xc(){
    val parameters: List<com.example.custom.Parameter> = listOf(
        Parameter("Paramètre 1", Icons.Default.Settings),
        Parameter("Paramètre 2", Icons.Default.AccountCircle),
        Parameter("Paramètre 3", Icons.Default.LocationOn),
        Parameter("Paramètre 4", Icons.Default.Phone)
    )
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    LazyColumn {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }



}
data class Parameter(val name:String,val icon: Any)
