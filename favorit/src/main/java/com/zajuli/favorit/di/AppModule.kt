package com.zajuli.favorit.di

import com.zajuli.favorit.favorite.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val favoritviewModelModule = module {
    viewModel { FavoriteViewModel(get()) }
}
