package com.github.arseniji.couriermobile.core.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.github.arseniji.couriermobile.core.datastore.UserData
import com.github.arseniji.couriermobile.core.datastore.UserDataSerializer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<UserData?>> {
        DataStoreFactory.create(
            serializer = UserDataSerializer,
            produceFile = { androidContext().dataStoreFile("user_data.json") },
        )
    }
}