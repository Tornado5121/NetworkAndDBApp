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

//fun UserArray.asDomainModel() : List<DomainUser>{
//    return results.map {
//        DomainUser(
//            id = it.login.uuid,
//            gender = it.userGender,
//            name = it.userFullName.name,
//            lastName = it.userFullName.lastName,
//            userPicture = it.userPicture.userPhotoLink
//        )
//    }
//}
