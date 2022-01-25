package com.natife.example.networkandbdapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private const val BASE_URL = "https://randomuser.me/"

class RetrofitClient @Inject constructor ()  {

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun requests(retrofit: Retrofit): Requests {
        return retrofit.create(Requests::class.java)
    }

}