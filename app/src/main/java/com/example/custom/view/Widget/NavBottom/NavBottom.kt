package com.example.custom.view.Widget.NavBottom

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custom.route.Screen


@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CustomAlign() {
    val currentScreen = mutableStateOf<Screen>(Screen.Home)
    Scaffold(bottomBar = {
        CustomBottomNavigationMain(currendScrenId = currentScreen.value.id) {
            currentScreen.value = it
        }
    }
    ) {

        when(currentScreen.value.id){
            "Accueil"-> Text(text = "Accueil")
            "Groupes"->Text(text = "Groupes")
            "Notification"->Text(text = "Notification")
            "Abonnement"->Text(text = "Abonnement")
            "Carte"->Text(text = "Carte")
        }
    }
}

@Composable
fun CustomBottomNavigationMain(currendScrenId: String, onItemSelected: (Screen) -> Unit) {
    val items = Screen.Items.list
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEach { item ->
            CustomBottomNavigationBody(item = item, isSelected = item.id == currendScrenId) {
                onItemSelected(item)
            }
        }
    }
}

@Composable
fun CustomBottomNavigationBody(item: Screen, isSelected: Boolean, onClick: () -> Unit) {
    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(imageVector = item.icon, contentDescription = null, tint = contentColor)
            AnimatedVisibility(visible = isSelected) {
                Text(text = item.title, color = contentColor)
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun CustomBottomNavigationPreview() {
    CustomAlign()
}