package com.github.arseniji.couriermobile.core.database
import androidx.room.AutoMigration
import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.arseniji.couriermobile.core.database.dao.ShiftDao
import com.github.arseniji.couriermobile.core.database.dao.SlotDao
import com.github.arseniji.couriermobile.core.database.model.SlotEntity

@Database(
    entities = [ShiftEntity::class, SlotEntity::class],
    version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class CourierDatabase : RoomDatabase() {
    abstract fun shiftDao(): ShiftDao
    abstract fun slotDao(): SlotDao
}