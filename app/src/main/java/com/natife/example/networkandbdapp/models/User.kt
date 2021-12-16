package com.natife.example.networkandbdapp.models

import com.google.gson.annotations.SerializedName
import com.natife.example.networkandbdapp.domain.DomainUser

data class User(
    val login: Login,

    @SerializedName("gender")
    val userGender: String,

    @SerializedName("name")
    val userFullName: UserFullName,

    @SerializedName("picture")
    val userPicture: UserPicture
)




