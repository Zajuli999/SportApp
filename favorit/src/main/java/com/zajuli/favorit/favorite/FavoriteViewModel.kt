package com.zajuli.favorit.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zajuli.sportapp.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}

