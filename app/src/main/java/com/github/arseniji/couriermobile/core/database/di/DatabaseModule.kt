package com.github.arseniji.couriermobile.core.database.di

import androidx.room.Room
import com.github.arseniji.couriermobile.core.database.CourierDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            CourierDatabase::class.java,
            "courier.db"
        ).build()
    }
    single { get<CourierDatabase>().shiftDao() }
}