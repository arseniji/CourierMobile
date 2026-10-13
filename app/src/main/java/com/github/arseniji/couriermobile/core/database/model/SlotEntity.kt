package com.github.arseniji.couriermobile.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.arseniji.couriermobile.core.model.Slot

@Entity(tableName = "slots")
data class SlotEntity(
    @PrimaryKey val id: Long,
    val startsAt: Long,
    val endsAt: Long,
    val hourlyRate: Int,
    val capacity: Int,
    val bookedCount: Int,
    val isBookedByMe: Boolean
)
fun SlotEntity.asExternalModel() : Slot =
    Slot(
        id = id,
        startsAt = startsAt,
        endsAt = endsAt,
        hourlyRate = hourlyRate,
        capacity = capacity,
        bookedCount = bookedCount,
        isBookedByMe = isBookedByMe
    )