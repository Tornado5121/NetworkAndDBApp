package com.natife.example.networkandbdapp.api

import com.natife.example.networkandbdapp.db.UserEntity
import com.natife.example.networkandbdapp.models.User
import com.natife.example.networkandbdapp.models.UserArray
import retrofit2.http.GET
import retrofit2.http.Query

interface Requests {
    @GET("api/")
    suspend fun getUserInfo(@Query ("results") numbers: Int) : UserArray
}