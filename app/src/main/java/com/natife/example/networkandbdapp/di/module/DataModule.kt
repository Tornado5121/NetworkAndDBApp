package com.natife.example.networkandbdapp.di.module

import android.content.Context
import com.natife.example.networkandbdapp.data.database.UserDao
import com.natife.example.networkandbdapp.data.database.UserDataBase
import com.natife.example.networkandbdapp.data.network.Requests
import com.natife.example.networkandbdapp.data.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class DataModule {

    @Provides
    @ActivityScoped
    fun providesDao(@ApplicationContext context: Context): UserDao {
        return UserDataBase.getInstance(context).userDao
    }

    @Provides
    @ActivityScoped
    fun providesRequests(retrofit: Retrofit): Requests {
        return RetrofitClient().requests(retrofit)
    }

    @Provides
    @ActivityScoped
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://randomuser.me/")
            .build()
    }

}