package com.natife.example.networkandbdapp.retrofitModels

import com.google.gson.annotations.SerializedName

data class UserFullName(
    @SerializedName("first")
    val name: String,

    @SerializedName("last")
    val lastName: String
)