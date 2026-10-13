package com.github.arseniji.couriermobile.feature.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
                Button(
                    onClick = onShiftToggle,
                    enabled = !state.isShiftActionInProgress) {
                    if (state.isShiftActionInProgress) CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                    else Text(if (state.isOnShift) "Закончить слот" else "Выйти на слот")
                }
            }
        }
    }

}
