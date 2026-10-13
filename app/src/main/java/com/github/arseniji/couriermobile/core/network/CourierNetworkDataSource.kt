package com.github.arseniji.couriermobile.core.network

import com.github.arseniji.couriermobile.core.network.model.NetworkShift
import com.github.arseniji.couriermobile.core.network.model.NetworkShiftEnded
import com.github.arseniji.couriermobile.core.network.model.NetworkUser

interface CourierNetworkDataSource{
    suspend fun getUser() : NetworkUser
    suspend fun startShift() : NetworkShift
    suspend fun endShift(shiftId: Long) : NetworkShiftEnded
}