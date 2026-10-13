package com.github.arseniji.couriermobile.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import com.github.arseniji.couriermobile.core.data.model.asUserData
import com.github.arseniji.couriermobile.core.datastore.UserData
import com.github.arseniji.couriermobile.core.datastore.asExternalModel
import com.github.arseniji.couriermobile.core.model.User
import com.github.arseniji.couriermobile.core.network.CourierNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class OfflineFirstUserRepository(
    private val dataStore: DataStore<UserData?>,
    private val network: CourierNetworkDataSource
): UserRepository {
    override val user: Flow<User> = dataStore.data
        .filterNotNull()
        .map{it.asExternalModel()}
        .onStart { refresh() }
    private suspend fun refresh(){
        try {
            val networkUser = network.getUser()
            dataStore.updateData { networkUser.asUserData() }
        } catch (e: IOException) {

        }
    }
}