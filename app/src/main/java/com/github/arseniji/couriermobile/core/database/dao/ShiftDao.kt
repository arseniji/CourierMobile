package com.github.arseniji.couriermobile.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShiftDao {
    @Query("SELECT * FROM shifts WHERE endedAt IS NULL LIMIT 1")
    fun observeActiveShift(): Flow<ShiftEntity?>

    @Query("SELECT * FROM shifts WHERE endedAt IS NULL LIMIT 1")
    suspend fun getActiveShift(): ShiftEntity?
    @Upsert
    suspend fun upsert(shift: ShiftEntity)

    @Query("UPDATE shifts SET endedAt = :endedAt WHERE id = :id")
    suspend fun endShift(id: Long,endedAt: Long)
}