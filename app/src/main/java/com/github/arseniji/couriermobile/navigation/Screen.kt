package com.github.arseniji.couriermobile.navigation


import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable data object Main : Screen
    @Serializable data object Map : Screen
    @Serializable data object Messages : Screen
    @Serializable data object Profile : Screen

}