package com.github.arseniji.couriermobile.core.data.model

import com.github.arseniji.couriermobile.core.datastore.UserData
import com.github.arseniji.couriermobile.core.network.model.NetworkUser

fun NetworkUser.asUserData() = UserData(id = id, name = name, storeName = storeName)