package com.natife.example.networkandbdapp.repositories

import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.db.UserDao
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.models.asDomainModel

class UserRepository(private val userDao: UserDao, private val api: Requests) {

    private val numberRequestedUsers = 10
    private var isLoadingNeeded = true

    suspend fun getAllUsers(): List<DomainUser> {
        return try {
            val users = api.getUserInfo(numberRequestedUsers).asDomainModel()
            if (!isLoadingNeeded) {
                isLoadingNeeded = true
            }
            userDao.insert(users.asDatabaseModel())
            users
        } catch (e: Exception) {
            e.printStackTrace()
            if (isLoadingNeeded) {
                isLoadingNeeded = false
                userDao.getAllUsers().asDomainModel()
            } else {
                emptyList()
            }
        }
    }

    fun getSingleUserInfo(id: String): DomainUser {
        return userDao.getUser(id).asDomainModel()
    }

    fun clearDb() {
        userDao.clearAllUsers()
    }

}
