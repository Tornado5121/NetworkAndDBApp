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
        try {
            val users = RetrofitClient.api.getUserInfo(numberRequestedUsers).asDomainModel()
            if (!isLoaded) {
                database.userDao.clearAllUsers()
                isLoaded = true
            }
            database.userDao.insert(users.asDatabaseModel())
        } catch (e: Exception) {
            e.printStackTrace()
            isLoaded = false
        }
        return database.userDao.getAllUsers().asDomainModel()
    }

    fun getSingleUserInfo(id: String): DomainUser {
        return database.userDao.getUser(id).asDomainModel()
    }

}
