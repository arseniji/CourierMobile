package com.github.arseniji.courierapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable data object Main : Screen
    @Serializable data object Map : Screen
    @Serializable data object Messages : Screen
    @Serializable data object Profile : Screen
}

data class TopLevelDestination(
    val screen: Screen,
    val label: String,
    val icon: ImageVector,
)

val topLevelDestinations = listOf(
    TopLevelDestination(Screen.Main, "Главная", Icons.Default.Home),
    TopLevelDestination(Screen.Map, "Карта", Icons.Default.Map),
    TopLevelDestination(Screen.Messages, "Сообщения", Icons.Filled.Message),
    TopLevelDestination(Screen.Profile, "Профиль", Icons.Default.Person),
)