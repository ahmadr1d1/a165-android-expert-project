package com.tourismapp.map

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mapsModule = module {
    viewModel { MapsViewModel(get()) }
}