package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.model.Slot
import kotlinx.coroutines.flow.Flow

interface SlotRepository {
    val upcomingSlots: Flow<List<Slot>>
    suspend fun bookSlot(slotId: Long)
}