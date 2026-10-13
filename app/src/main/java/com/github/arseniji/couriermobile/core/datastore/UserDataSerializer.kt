package com.github.arseniji.couriermobile.core.datastore

import kotlinx.serialization.SerializationException
import androidx.datastore.core.Serializer
import androidx.datastore.core.CorruptionException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object UserDataSerializer : Serializer<UserData?> {
    private val json = Json { ignoreUnknownKeys = true }

    override val defaultValue: UserData? = null

    override suspend fun readFrom(input: InputStream): UserData? =
        try {
            json.decodeFromString<UserData>(input.readBytes().decodeToString())
        } catch (e: SerializationException) {
            throw CorruptionException("Не удалось прочитать UserData", e)
        }

    override suspend fun writeTo(t: UserData?, output: OutputStream) {
        if (t != null) output.write(json.encodeToString(t).encodeToByteArray())
    }
}