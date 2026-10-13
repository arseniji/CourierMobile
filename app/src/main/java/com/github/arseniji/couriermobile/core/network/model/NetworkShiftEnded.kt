package com.github.arseniji.couriermobile.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkShiftEnded(
    val shiftId: Long,
    val endedAt: Long,
)