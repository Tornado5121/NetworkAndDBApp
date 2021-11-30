package com.natife.example.networkandbdapp.models

import com.google.gson.annotations.SerializedName

data class UserArray(
    @SerializedName("results")
    val userArray: List<User> = emptyList()
)


