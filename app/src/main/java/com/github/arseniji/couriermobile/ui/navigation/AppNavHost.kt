package com.github.arseniji.couriermobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.arseniji.couriermobile.ui.home.MainScreen
import com.github.arseniji.couriermobile.ui.map.MapScreen
import com.github.arseniji.couriermobile.ui.messages.MessagesScreen
import com.github.arseniji.couriermobile.ui.profile.ProfileScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main,
        modifier = modifier
    ) {
        composable<Screen.Main>{ MainScreen() }
        composable<Screen.Map>{ MapScreen() }
        composable<Screen.Messages> { MessagesScreen() }
        composable<Screen.Profile> { ProfileScreen() }
    }
}