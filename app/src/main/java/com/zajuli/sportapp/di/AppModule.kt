package com.zajuli.sportapp.di

import com.zajuli.sportapp.core.domain.usecase.TourismInteractor
import com.zajuli.sportapp.core.domain.usecase.TourismUseCase
import com.zajuli.sportapp.detail.DetailTourismViewModel
import com.zajuli.sportapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}