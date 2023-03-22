package com.example.custom.view.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custom.R

@Composable
fun Profil() {

}
@Composable
fun ProfilBody() {

}

@Composable
@Preview
fun ProfilBodyPreview() {
    UserProfile()
}
@Composable
@Preview
fun UserProfile() {
    Column(modifier = Modifier.padding(3.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, ){
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "User profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(78.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.Gray, CircleShape)
            )
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "Elie Oko",
                )
                Row(modifier = Modifier.padding(5.dp),horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                    Text(
                        text = "Sango",
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "Groupes",
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "Reactions",
                    )
                }
                Row(modifier = Modifier.padding(5.dp),horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "0",
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "0",
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "0",
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Software Engineer",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sed enim felis. Suspendisse potenti. Sed vitae imperdiet purus. Morbi vel ex quis quam scelerisque bibendum. Duis aliquet, sapien euismod dapibus bibendum, ligula nunc commodo nunc, a luctus ligula mauris vel dolor.",
            style = MaterialTheme.typography.body2
        )
    }
}
