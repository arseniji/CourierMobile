package com.github.arseniji.couriermobile.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.arseniji.couriermobile.core.data.repository.ShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val shiftRepository: ShiftRepository,
    userRepository: UserRepository
) : ViewModel() {
    val uiState: StateFlow<HomeUiState> = combine(
        userRepository.user,
        shiftRepository.isOnShift,
        ) {user, isOnShift ->
        HomeUiState.Success(
            courierName = user.name,
            storeName = user.storeName,
            isOnShift = isOnShift
        )
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