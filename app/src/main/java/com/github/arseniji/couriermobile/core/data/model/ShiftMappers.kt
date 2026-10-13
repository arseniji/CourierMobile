package com.github.arseniji.couriermobile.core.data.model

import com.github.arseniji.couriermobile.core.database.model.ShiftEntity
import com.github.arseniji.couriermobile.core.network.model.NetworkShift

fun NetworkShift.asEntity() = ShiftEntity(
    id = id,
    startedAt = startedAt,
    endedAt = endedAt,
)