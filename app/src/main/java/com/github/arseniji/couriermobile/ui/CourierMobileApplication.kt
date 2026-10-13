package com.github.arseniji.couriermobile.ui

import android.app.Application
import com.github.arseniji.couriermobile.core.data.di.dataModule
import com.github.arseniji.couriermobile.core.database.di.databaseModule
import com.github.arseniji.couriermobile.feature.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CourierMobileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CourierMobileApplication)
            modules(dataModule, homeModule, databaseModule)
        }
    }
}