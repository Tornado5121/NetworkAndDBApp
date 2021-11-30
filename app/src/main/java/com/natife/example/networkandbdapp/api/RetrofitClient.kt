package com.natife.example.networkandbdapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        val BASE_URL = "https://randomuser.me/"
        var retrofit: Retrofit? = null

        fun getInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit =
                    Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
            }
            return retrofit
        }
    }
}