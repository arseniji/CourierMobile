package com.github.arseniji.couriermobile.core.data.repository

import kotlinx.coroutines.flow.Flow

interface ShiftRepository {
    val isOnShift: Flow<Boolean>
    suspend fun startShift()
    suspend fun endShift()
}