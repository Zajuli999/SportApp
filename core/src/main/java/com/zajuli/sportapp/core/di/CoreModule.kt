package com.zajuli.sportapp.core.di

import androidx.room.Room
import com.zajuli.sportapp.core.data.TourismRepository
import com.zajuli.sportapp.core.data.source.local.LocalDataSource
import com.zajuli.sportapp.core.data.source.local.room.TourismDatabase
import com.zajuli.sportapp.core.data.source.remote.RemoteDataSource
import com.zajuli.sportapp.core.data.source.remote.network.ApiService
import com.zajuli.sportapp.core.domain.repository.ITourismRepository
import com.zajuli.sportapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<TourismDatabase>().tourismDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            TourismDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITourismRepository> {
        TourismRepository(
            get(),
            get(),
            get()
        )
    }
}