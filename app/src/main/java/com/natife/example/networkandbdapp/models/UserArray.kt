package com.natife.example.networkandbdapp.models

import com.natife.example.networkandbdapp.db.UserEntity

data class UserArray(
    val results: List<User>
)

fun UserArray.asDatabaseModel() : List<UserEntity> {
    return results.map {
        UserEntity(
            id = it.login.uuid,
            userGender = it.userGender,
            name = it.userFullName.name,
            lastName = it.userFullName.lastName,
            userPhotoLink = it.userPicture.userPhotoLink
        )
    }
}
