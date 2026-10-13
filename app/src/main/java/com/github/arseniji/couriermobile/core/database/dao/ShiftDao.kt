package com.github.arseniji.couriermobile.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShiftDao {
    @Query("SELECT * FROM shifts WHERE endedAt IS NULL LIMIT 1")
    fun observeActiveShift(): Flow<ShiftEntity?>

    @Insert
    suspend fun insert(shift: ShiftEntity)

    @Query("UPDATE shifts SET endedAt = :endedAt WHERE endedAt IS NULL")
    suspend fun endActiveShift(endedAt: Long)
}