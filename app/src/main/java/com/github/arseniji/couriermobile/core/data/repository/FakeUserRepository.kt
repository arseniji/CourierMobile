package com.github.arseniji.couriermobile.core.data.repository

import com.github.arseniji.couriermobile.core.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeUserRepository: UserRepository {
    override val user: Flow<User> = flowOf(User(id = 1, name = "Вова", storeName = "Бананчиковое"))
}