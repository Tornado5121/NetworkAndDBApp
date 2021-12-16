package com.natife.example.networkandbdapp.repositories

import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.UserEntity
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.models.asDomainModel

class UserRepository(private val database: UserDataBase) {

    private val numberRequestedUsers = 10
//    val userListFromDb: LiveData<List<UserEntity>> = database.userDao.getAllUsersByLiveData()

    suspend fun getAllUsersByApi(): List<DomainUser>? {
        return try {
            RetrofitClient.api.getUserInfo(numberRequestedUsers).asDomainModel()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun getSingleUserInfo(id: String): UserEntity {
        return database.userDao.getUser(id)
    }

}
