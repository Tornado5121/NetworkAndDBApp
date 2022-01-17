package com.natife.example.networkandbdapp.data.network

import com.natife.example.networkandbdapp.retrofitModels.UserArray
import retrofit2.http.GET
import retrofit2.http.Query

interface Requests {

    @GET("api/")
    suspend fun getUserInfo(@Query ("results") numbers: Int) : UserArray

}