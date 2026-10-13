package com.github.arseniji.couriermobile.core.data.model

import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import com.github.arseniji.couriermobile.core.database.model.SlotEntity
import com.github.arseniji.couriermobile.core.network.model.NetworkShift
import com.github.arseniji.couriermobile.core.network.model.NetworkSlot

fun NetworkSlot.asEntity() = SlotEntity(
    id = id,
    startsAt = startsAt,
    endsAt = endsAt,
    hourlyRate = hourlyRate,
    capacity = capacity,
    bookedCount = bookedCount,
    isBookedByMe = isBookedByMe
)