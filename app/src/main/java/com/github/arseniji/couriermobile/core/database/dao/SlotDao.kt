package com.github.arseniji.couriermobile.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.github.arseniji.couriermobile.core.database.model.SlotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SlotDao {
    @Query("Select * from slots where endsAt > :now order by startsAt")
    fun observeUpcoming(now: Long): Flow<List<SlotEntity>>

    @Upsert
    suspend fun upsertAll(slots: List<SlotEntity>)

}