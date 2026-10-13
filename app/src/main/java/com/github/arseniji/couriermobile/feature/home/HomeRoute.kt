package com.github.arseniji.couriermobile.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = koinViewModel()
){
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        state = state,
        onShiftToggle = viewModel::onShiftToggle
    )
}