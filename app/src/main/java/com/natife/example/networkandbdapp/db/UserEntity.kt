package com.natife.example.networkandbdapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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

//fun List<UserEntity>.asDomainModel(): List<DomainUser> {
//    return map {
//        it.asDomainModel()
////            id = it.id,
////            name = it.name,
////            lastName = it.lastName,
////            gender = it.userGender,
////            userPicture = it.userPhotoLink
////        )
//    }
//}
//
//fun UserEntity.asDomainModel(): DomainUser {
//    return DomainUser(
//            id = id,
//            name = name,
//            lastName = lastName,
//            gender = userGender,
//            userPicture = userPhotoLink
//        )
//}