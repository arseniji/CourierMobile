package com.github.arseniji.couriermobile.core.data.di

import com.github.arseniji.couriermobile.core.data.repository.FakeShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.OfflineFirstShiftRepository
import com.github.arseniji.couriermobile.core.data.repository.ShiftRepository
import org.koin.dsl.module

val dataModule = module {
    single<ShiftRepository> { OfflineFirstShiftRepository(get()) }
}