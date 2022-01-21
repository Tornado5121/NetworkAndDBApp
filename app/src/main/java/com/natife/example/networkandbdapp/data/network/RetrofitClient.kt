package com.natife.example.networkandbdapp.data.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitClient {

    private const val BASE_URL = "https://randomuser.me/"

    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun requests(retrofit: Retrofit): Requests {
        return retrofit.create(Requests::class.java)
    }

}