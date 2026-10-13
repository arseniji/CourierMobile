package com.github.arseniji.couriermobile.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.arseniji.couriermobile.core.data.repository.ShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel(
    private val shiftRepository: ShiftRepository,
    userRepository: UserRepository
) : ViewModel() {

    private data class ShiftActionState(
        val inProgress: Boolean = false,
        val errorMessage: String? = null
    )

    private val actionState = MutableStateFlow(ShiftActionState())
    val uiState: StateFlow<HomeUiState> = combine(
        userRepository.user,
        shiftRepository.isOnShift,
        actionState
        ) {user, isOnShift, action ->
        HomeUiState.Success(
            courierName = user.name,
            storeName = user.storeName,
            isOnShift = isOnShift,
            isShiftActionInProgress = action.inProgress,
            errorMessage = action.errorMessage
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiState.Loading
        )

    fun onShiftToggle() {
        val current = uiState.value
        if (current !is HomeUiState.Success || current.isShiftActionInProgress) return

        viewModelScope.launch {
            actionState.update { it.copy(inProgress = true) }
            try {
                if (current.isOnShift) shiftRepository.endShift()
                else shiftRepository.startShift()
            } catch (e: IOException) {
                val message = if (current.isOnShift) "Не удалось завершить смену" else "Не удалось начать смену"
                actionState.update { it.copy(errorMessage = message) }
            } finally {
                actionState.update { it.copy(inProgress = false) }
            }
        }
    }

    fun onErrorShown() {
        actionState.update { it.copy(errorMessage = null) }
    }

}