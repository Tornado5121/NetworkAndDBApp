package com.natife.example.networkandbdapp.models

import com.google.gson.annotations.SerializedName

data class User(

    val login: Login,

    @SerializedName("gender")
    val userGender: String,

    @SerializedName("name")
    val userFullName: UserFullName,

    @SerializedName("picture")
    val userPicture: UserPicture
)

//fun UserArray.asDomainModel(): List<User> {
//    return userArray.map {
//        User(
//            userGender = it.userGender,
//            userFullName = it.userFullName,
//            userPicture = it.userPicture,
//        )
//    }

