package com.zajuli.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zajuli.sportapp.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}

