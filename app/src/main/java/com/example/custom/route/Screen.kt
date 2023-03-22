package com.example.custom.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screen("home", "Accueil", Icons.Outlined.Home)
    object Groupe : Screen("groupes", "Groupes", Icons.Outlined.Add)
    object Notification : Screen("notification", "Notification", Icons.Outlined.Notifications)
    object Abonnement : Screen("abonnement", "Abonnement", Icons.Outlined.Person)
    object Carte : Screen("carte", "Carte", Icons.Outlined.LocationOn)

    object Items {
        val list = listOf(
            Home,
            Groupe,
            Notification,
            Abonnement,
            Carte
        )
    }
}

