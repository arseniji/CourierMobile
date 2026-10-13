package com.github.arseniji.couriermobile.core.database
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.arseniji.couriermobile.core.database.dao.ShiftDao

@Database(entities = [ShiftEntity::class], version = 1)
abstract class CourierDatabase : RoomDatabase() {
    abstract fun shiftDao(): ShiftDao
}