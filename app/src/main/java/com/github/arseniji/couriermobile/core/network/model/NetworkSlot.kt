package com.github.arseniji.couriermobile.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSlot(
    val id: Long,
    val startsAt: Long,
    val endsAt: Long,
    val hourlyRate: Int,
    val capacity: Int,
    val bookedCount: Int,
    val isBookedByMe: Boolean
)
