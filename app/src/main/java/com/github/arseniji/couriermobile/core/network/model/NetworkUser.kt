package com.github.arseniji.couriermobile.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkUser(
    val id: Int,
    val name: String,
    val storeName: String
) {
}