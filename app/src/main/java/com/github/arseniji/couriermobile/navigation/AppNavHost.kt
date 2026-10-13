package com.github.arseniji.couriermobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.arseniji.couriermobile.feature.home.HomeRoute
import com.github.arseniji.couriermobile.feature.home.HomeScreen
import com.github.arseniji.couriermobile.feature.home.HomeUiState
import com.github.arseniji.couriermobile.feature.map.MapScreen
import com.github.arseniji.couriermobile.feature.messages.MessagesScreen
import com.github.arseniji.couriermobile.feature.profile.ProfileScreen


@Composable
fun AppNavHost(
    navController: NavHostController,
    onShowSnackbar: suspend (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main,
        modifier = modifier
    ) {
        composable<Screen.Main> {
            HomeRoute(onShowSnackbar)
        }
        composable<Screen.Map> {
            MapScreen()
        }
        composable<Screen.Messages> {
            MessagesScreen()
        }
        composable<Screen.Profile> {
            ProfileScreen()
        }
    }
}
