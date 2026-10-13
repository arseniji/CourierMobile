package com.github.arseniji.couriermobile.feature.home


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun HomeScreen(
    state: HomeUiState,
    onShiftToggle: () -> Unit
) {
    when (state){
        HomeUiState.Loading -> CircularProgressIndicator()
        is HomeUiState.Success -> {
            Column() {
                Text("Привет ${state.courierName}")
                Text("Даркстор: ${state.storeName}")
                Button(onShiftToggle) {
                    Text(if (state.isOnShift) "Закончить слот" else "Выйти на слот")
                }
            }
        }
    }

}
