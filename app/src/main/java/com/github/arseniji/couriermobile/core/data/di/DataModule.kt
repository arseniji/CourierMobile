package com.github.arseniji.couriermobile.core.data.di

import com.github.arseniji.couriermobile.core.data.repository.OfflineFirstShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.OfflineFirstSlotRepository
import com.github.arseniji.couriermobile.core.data.repository.OfflineFirstUserRepository
import com.github.arseniji.couriermobile.core.data.repository.ShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.SlotRepository
import com.github.arseniji.couriermobile.core.data.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<ShiftRepository> { OfflineFirstShiftRepository(get(),get()) }
    single<UserRepository> { OfflineFirstUserRepository(get(),get()) }
    single<SlotRepository>{ OfflineFirstSlotRepository(get(),get()) }
}