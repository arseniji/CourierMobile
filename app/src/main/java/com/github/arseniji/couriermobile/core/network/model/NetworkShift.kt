package com.github.arseniji.couriermobile.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkShift(
    val id: Long,
    val startedAt: Long,
    val endedAt: Long? = null
)
