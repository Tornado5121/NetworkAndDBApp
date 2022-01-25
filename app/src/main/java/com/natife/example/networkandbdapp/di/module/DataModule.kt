package com.natife.example.networkandbdapp.di.module

import android.content.Context
import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.UserDao
import com.natife.example.networkandbdapp.data.database.UserDataBase
import com.natife.example.networkandbdapp.data.network.Requests
import com.natife.example.networkandbdapp.data.network.RetrofitClient
import com.natife.example.networkandbdapp.di.qualifiers.MyDatabaseRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun providesDao(context: Context): UserDao {
        return UserDataBase.getInstance(context).userDao
    }

    @Singleton
    @Provides
    fun providesRequests(retrofit: Retrofit): Requests {
        return RetrofitClient().requests(retrofit)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://randomuser.me/")
            .build()
    }

}