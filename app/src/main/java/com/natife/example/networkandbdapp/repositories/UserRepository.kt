package com.natife.example.networkandbdapp.repositories

import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.models.asDomainModel

class UserRepository(private val database: UserDataBase) {
    private val numberRequestedUsers = 10
    private var isLoaded = true

    suspend fun getAllUsers(): List<DomainUser> {
        return try {
            isLoaded = false
            if (isLoaded) {
                database.userDao.clearAllUsers()
            }
            val users = RetrofitClient.api.getUserInfo(numberRequestedUsers).asDomainModel()
            database.userDao.insert(users.asDatabaseModel())
            isLoaded = false
            database.userDao.getAllUsers().asDomainModel()
        } catch (e: Exception) {
            e.printStackTrace()
            isLoaded = true
            if (!isLoaded) {
                database.userDao.getAllUsers().asDomainModel()
            }
            emptyList()
        }

    }

    fun getSingleUserInfo(id: String): DomainUser {
        return database.userDao.getUser(id).asDomainModel()
    }

}
