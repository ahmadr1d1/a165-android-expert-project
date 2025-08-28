package com.tourismapp.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}