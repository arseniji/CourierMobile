package com.github.arseniji.couriermobile.core.network.di

import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import com.github.arseniji.couriermobile.core.network.demo.DemoCourierNetworkDataSource
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single { Json { ignoreUnknownKeys = true } }
    single<CourierNetworkDataSource> {
        DemoCourierNetworkDataSource(androidContext().assets, get())
    }
}