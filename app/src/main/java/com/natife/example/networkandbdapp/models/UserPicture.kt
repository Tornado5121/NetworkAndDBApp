package com.natife.example.networkandbdapp.models

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("large")
    val userPhotoLink: String
)