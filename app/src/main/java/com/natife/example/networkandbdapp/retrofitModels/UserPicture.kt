package com.natife.example.networkandbdapp.retrofitModels

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("large")
    val userPhotoLink: String
)