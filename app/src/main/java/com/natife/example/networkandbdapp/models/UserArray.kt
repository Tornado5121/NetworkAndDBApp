package com.natife.example.networkandbdapp.models

import com.natife.example.networkandbdapp.domain.DomainUser

data class UserArray(
    val results: List<User>
)

fun UserArray.asDomainModel(): List<DomainUser> {
    return results.map {
        DomainUser(
            id = it.login.uuid,
            gender = it.userGender,
            name = it.userFullName.name,
            lastName = it.userFullName.lastName,
            picture = it.userPicture.userPhotoLink
        )
    }
}


