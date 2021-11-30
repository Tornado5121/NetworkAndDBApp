package com.natife.example.networkandbdapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "user gender")
    val userGender: String,

    @ColumnInfo(name = "username")
    val name: String,

    @ColumnInfo(name = "user lastname")
    val lastName: String,

    @ColumnInfo(name = "link to user photo")
    val userPhotoLink: String
)