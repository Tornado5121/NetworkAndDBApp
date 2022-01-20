package com.natife.example.networkandbdapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.natife.example.networkandbdapp.domain.DomainUser

@Entity
data class UserEntity(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "user gender")
    val userGender: String,

    @ColumnInfo(name = "username")
    val name: String,

    @ColumnInfo(name = "user lastname")
    val lastName: String,

    @ColumnInfo(name = "link to user photo")
    val userPhotoLink: String
)

fun List<UserEntity>.asDomainModel(): List<DomainUser> {
    return map { it.asDomainModel() }
}

fun UserEntity.asDomainModel(): DomainUser {
    return DomainUser(
        id = id,
        name = name,
        lastName = lastName,
        gender = userGender,
        picture = userPhotoLink
    )
}