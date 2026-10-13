package com.github.arseniji.couriermobile.core.network.demo

import android.content.res.AssetManager
import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import com.github.arseniji.couriermobile.core.network.model.NetworkShift
import com.github.arseniji.couriermobile.core.network.model.NetworkShiftEnded
import com.github.arseniji.couriermobile.core.network.model.NetworkUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class DemoCourierNetworkDataSource(
    private val assets: AssetManager,
    private val json: Json,
) : CourierNetworkDataSource {

    override suspend fun getUser(): NetworkUser {
        delay(500)
        val text = withContext(Dispatchers.IO) {
            assets.open("user.json").bufferedReader().use { it.readText() }
        }
        return json.decodeFromString(text)
    }

    override suspend fun startShift(): NetworkShift {
        delay(500)
        return NetworkShift(id = System.currentTimeMillis(), startedAt = System.currentTimeMillis())
    }

    override suspend fun endShift(shiftId: Long): NetworkShiftEnded{
        delay(500)
        return NetworkShiftEnded(shiftId=shiftId, endedAt = System.currentTimeMillis())
    }
}