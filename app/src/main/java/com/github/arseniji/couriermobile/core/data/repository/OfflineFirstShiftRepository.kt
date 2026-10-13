package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.data.model.asEntity
import com.github.arseniji.couriermobile.core.database.dao.ShiftDao
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineFirstShiftRepository(
    private val shiftDao: ShiftDao,
    private val network: CourierNetworkDataSource,
) : ShiftRepository {

    override val isOnShift: Flow<Boolean> =
        shiftDao.observeActiveShift().map { it != null }

    override suspend fun startShift() {
        val shift = network.startShift()
        shiftDao.upsert(shift.asEntity())
    }

    override suspend fun endShift() {
        val active = shiftDao.getActiveShift() ?: return
        val ended = network.endShift(active.id)
        shiftDao.endShift(ended.shiftId, ended.endedAt)
    }
}