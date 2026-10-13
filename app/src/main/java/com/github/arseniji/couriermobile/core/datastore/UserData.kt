package com.github.arseniji.couriermobile.core.datastore

import com.github.arseniji.couriermobile.core.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserData(val id: Int, val name: String, val storeName: String)

fun UserData.asExternalModel() = User(id = id, name = name, storeName = storeName)