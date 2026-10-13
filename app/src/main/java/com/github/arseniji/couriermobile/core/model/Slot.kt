package com.github.arseniji.couriermobile.core.model

data class Slot(
    val id: Long,
    val startsAt: Long,
    val endsAt: Long,
    val hourlyRate: Int,
    val capacity: Int,
    val bookedCount: Int,
    val isBookedByMe: Boolean
)
