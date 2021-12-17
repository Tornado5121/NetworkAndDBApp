package com.natife.example.networkandbdapp.domain

import com.natife.example.networkandbdapp.db.UserEntity

data class DomainUser(
    val id: String,
    val name: String,
    val lastName: String,
    val gender: String,
    val picture: String
)

fun List<DomainUser>.asDatabaseModel(): List<UserEntity> {
    return map {
        it.asDatabaseModel()
    }
}

fun DomainUser.asDatabaseModel(): UserEntity {
    return UserEntity(
        id = id,
        userGender = gender,
        name = name,
        lastName = lastName,
        userPhotoLink = picture
    )
}

