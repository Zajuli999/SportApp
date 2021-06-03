package com.zajuli.sportapp.detail

import androidx.lifecycle.ViewModel
import com.zajuli.sportapp.core.domain.model.Tourism
import com.zajuli.sportapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

