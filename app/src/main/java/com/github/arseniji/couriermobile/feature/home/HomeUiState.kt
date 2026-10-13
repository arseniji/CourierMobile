package com.github.arseniji.couriermobile.feature.home

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(
        val courierName: String,
        val storeName: String,
        val isOnShift: Boolean
    ) : HomeUiState
}