package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    val user: Flow<User>
}