package com.natife.example.networkandbdapp.models

import com.google.gson.annotations.SerializedName

class UserArray {

    @SerializedName("results")
    val userArray: List<User> = emptyList()

    fun getUserArray() {

    }
}