package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.database.dao.ShiftDao
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineFirstShiftRepository (
    private val shiftDao: ShiftDao
) : ShiftRepository{
    override val isOnShift: Flow<Boolean> = shiftDao.observeActiveShift().map { it!=null }
    override suspend fun startShift() {
        shiftDao.insert(ShiftEntity(startedAt = System.currentTimeMillis()))
    }

    override suspend fun endShift() {
        shiftDao.endActiveShift(System.currentTimeMillis())
    }
}