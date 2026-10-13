package com.github.arseniji.couriermobile.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelDestination(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
)

val topLevelDestinations = listOf(
    TopLevelDestination(Screen.Main, "Главная", Icons.Default.Home),
    TopLevelDestination(Screen.Map, "Карта", Icons.Default.Map),
    TopLevelDestination(Screen.Messages, "Сообщения", Icons.AutoMirrored.Filled.Message),
    TopLevelDestination(Screen.Profile, "Профиль", Icons.Default.Person),
)
