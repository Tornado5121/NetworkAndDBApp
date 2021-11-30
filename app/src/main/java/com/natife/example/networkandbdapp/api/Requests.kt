package com.natife.example.networkandbdapp.api

import com.natife.example.networkandbdapp.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Requests {
    @GET("api/")
    fun getUserInfo(@Query("results") result: Int) : Call<User>
}