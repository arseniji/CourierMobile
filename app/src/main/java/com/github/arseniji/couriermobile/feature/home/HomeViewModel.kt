package com.github.arseniji.couriermobile.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.arseniji.couriermobile.core.data.repository.ShiftRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val shiftRepository: ShiftRepository
) : ViewModel() {
    val uiState: StateFlow<HomeUiState> = shiftRepository
        .isOnShift
        .map { onShift ->
            HomeUiState.Success(courierName = "Вова", storeName = "Жопа", isOnShift = onShift)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiState.Loading
        )

    fun onShiftToggle(){
        val current: HomeUiState = uiState.value
        if (current !is HomeUiState.Success) return

        viewModelScope.launch {
            if (current.isOnShift) shiftRepository.endShift()
            else shiftRepository.startShift()
        }
    }

}