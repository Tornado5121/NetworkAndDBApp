package com.natife.example.networkandbdapp

import android.app.Application
import com.natife.example.networkandbdapp.di.AppComponent
import com.natife.example.networkandbdapp.di.ContextModule
import com.natife.example.networkandbdapp.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

}