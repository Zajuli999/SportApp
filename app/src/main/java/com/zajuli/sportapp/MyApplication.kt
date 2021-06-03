package com.zajuli.sportapp

import android.app.Application
import com.zajuli.sportapp.core.di.databaseModule
import com.zajuli.sportapp.core.di.networkModule
import com.zajuli.sportapp.core.di.repositoryModule
import com.zajuli.sportapp.di.useCaseModule
import com.zajuli.sportapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}