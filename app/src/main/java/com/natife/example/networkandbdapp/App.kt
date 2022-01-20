package com.natife.example.networkandbdapp

import android.app.Application
import com.natife.example.networkandbdapp.di.dataModule
import com.natife.example.networkandbdapp.di.viewModelModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataModule, viewModelModule))
        }
    }
}