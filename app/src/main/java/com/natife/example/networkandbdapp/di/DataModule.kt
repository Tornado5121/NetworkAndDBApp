package com.natife.example.networkandbdapp.di

import android.app.Application
import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.DataBaseRepository
import com.natife.example.networkandbdapp.data.database.UserDataBase
import com.natife.example.networkandbdapp.data.network.Requests
import com.natife.example.networkandbdapp.data.network.UserFetcherImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun getUserFetcher(): UserFetcher {
        return UserFetcherImpl(
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://randomuser.me/")
                .build().create(Requests::class.java)
        )
    }

    @Singleton
    @Provides
    @Named("databaseRepo")
    fun getDataBaseRepo(application: Application): UserDataRepository {
        return DataBaseRepository(UserDataBase.getInstance(application).userDao)
    }

    @Singleton
    @Provides
    @Named("userRepo")
    fun getUserRepo(application: Application): UserDataRepository {
        return UserRepository(getDataBaseRepo(application), getUserFetcher())
    }

}