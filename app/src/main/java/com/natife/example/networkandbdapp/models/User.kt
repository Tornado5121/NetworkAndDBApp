package com.natife.example.networkandbdapp.models

import androidx.room.Entity

@Entity
data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val userPhotoLink: String,
    val description: String
)