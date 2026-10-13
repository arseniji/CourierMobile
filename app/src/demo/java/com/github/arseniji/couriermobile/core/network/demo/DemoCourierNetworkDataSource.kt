package com.github.arseniji.couriermobile.core.network.demo

import android.content.res.AssetManager
import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import com.github.arseniji.couriermobile.core.network.model.NetworkShift
import com.github.arseniji.couriermobile.core.network.model.NetworkShiftEnded
import com.github.arseniji.couriermobile.core.network.model.NetworkSlot
import com.github.arseniji.couriermobile.core.network.model.NetworkUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.IOException
import java.time.LocalDate
import java.time.ZoneId
import kotlin.random.Random

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
        if (Random.nextInt(3) == 0) throw IOException("demo: сервер недоступен")
        return NetworkShift(id = System.currentTimeMillis(), startedAt = System.currentTimeMillis())
    }

    override suspend fun endShift(shiftId: Long): NetworkShiftEnded{
        if (Random.nextInt(3) == 0) throw IOException("demo: сервер недоступен")
        delay(500)
        return NetworkShiftEnded(shiftId=shiftId, endedAt = System.currentTimeMillis())
    }

    private val bookedIds = mutableSetOf<Long>()

    override suspend fun getSlots(): List<NetworkSlot> {
        delay(500)
        val zone = ZoneId.systemDefault()
        val today = LocalDate.now(zone)
        return (0 until 7).flatMap { dayOffset ->
            val day = today.plusDays(dayOffset.toLong())
            listOf(8, 12, 16, 20).map { hour ->
                val start = day.atTime(hour, 0).atZone(zone)
                val id = start.toEpochSecond()
                NetworkSlot(
                    id = id,
                    startsAt = start.toInstant().toEpochMilli(),
                    endsAt = start.plusHours(4).toInstant().toEpochMilli(),
                    hourlyRate = if (hour == 20) 350 else 300,
                    capacity = 3,
                    bookedCount = (id % 3).toInt() + if (id in bookedIds) 1 else 0,
                    isBookedByMe = id in bookedIds,
                )
            }
        }
    }

    override suspend fun bookSlot(slotId: Long): NetworkSlot {
        delay(500)
        if (Random.nextInt(4) == 0) throw IOException("demo: не удалось записаться")
        bookedIds += slotId
        return getSlots().first { it.id == slotId }
    }
}