package com.github.arseniji.couriermobile.feature.home.di

import org.koin.core.module.dsl.viewModel
import com.github.arseniji.couriermobile.feature.home.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get(),get()) }
}