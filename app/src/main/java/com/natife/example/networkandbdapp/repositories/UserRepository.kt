package com.natife.example.networkandbdapp.repositories

import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.models.asDomainModel

class UserRepository(private val database: UserDataBase) {
    private val numberRequestedUsers = 10

    suspend fun getAllUsers(): List<DomainUser> {

        return try {
            val users = RetrofitClient.api.getUserInfo(numberRequestedUsers).asDomainModel()
            if (users.isNotEmpty()) {
                database.userDao.clearAllUsers()
                database.userDao.insert(users.asDatabaseModel())
            }
            database.userDao.getAllUsers().asDomainModel()

        } catch (e: Exception) {
            e.printStackTrace()
            database.userDao.getAllUsers().asDomainModel()
        }
    }

    fun getSingleUserInfo(id: String): DomainUser {
        return database.userDao.getUser(id).asDomainModel()
    }

}
