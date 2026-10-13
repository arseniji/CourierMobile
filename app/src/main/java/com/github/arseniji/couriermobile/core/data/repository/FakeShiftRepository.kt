package com.github.arseniji.couriermobile.core.data.repository


import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach

class FakeShiftRepository : ShiftRepository {
    private val state = MutableStateFlow(false)
    override val isOnShift: Flow<Boolean> = state.onEach { delay(1500) }
    override suspend fun startShift()  {state.value = true }
    override suspend fun endShift() { state.value = false }
}