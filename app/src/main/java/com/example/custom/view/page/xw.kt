package com.example.custom.view.page

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material.Surface
import java.util.*

@Composable
@Preview
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bienvenue sur notre application",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )
//        Image(
//            painter = painterResource(id = R),
//            contentDescription = "Jetpack Compose Logo",
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .padding(bottom = 16.dp)
//        )
        Text(
            text = "Notre application vous permet de découvrir les dernières fonctionnalités de Jetpack Compose.",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Action à effectuer lors du clic sur le bouton */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Commencer")
        }
    }
}
