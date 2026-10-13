package com.github.arseniji.couriermobile.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    onShowSnackbar: suspend (String) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
){
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val errorMessage = (state as? HomeUiState.Success)?.errorMessage
    LaunchedEffect(errorMessage) {
        if (errorMessage!=null){
            onShowSnackbar(errorMessage)
            viewModel.onErrorShown()
        }
    }

    HomeScreen(
        state = state,
        onShiftToggle = viewModel::onShiftToggle
    )
}