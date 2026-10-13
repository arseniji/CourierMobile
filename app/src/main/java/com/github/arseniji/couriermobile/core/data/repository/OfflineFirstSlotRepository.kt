package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.data.model.asEntity
import com.github.arseniji.couriermobile.core.database.dao.SlotDao
import com.github.arseniji.couriermobile.core.database.model.asExternalModel
import com.github.arseniji.couriermobile.core.model.Slot
import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import java.io.IOException

class OfflineFirstSlotRepository(
    private val slotDao : SlotDao,
    private val network: CourierNetworkDataSource
) : SlotRepository{
    override val upcomingSlots: Flow<List<Slot>> =
        slotDao.observeUpcoming(System.currentTimeMillis())
            .map {e -> e.map {it.asExternalModel()}}
            .onStart { refresh() }

    override suspend fun bookSlot(slotId: Long) {
        var slot = network.bookSlot(slotId)
        slotDao.upsertAll(listOf(slot.asEntity()))
    }

    private suspend fun refresh(){
        try{
            slotDao.upsertAll(network.getSlots().map{it.asEntity()})
        } catch (e: IOException){}
    }
}