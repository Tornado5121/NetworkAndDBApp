package com.natife.example.networkandbdapp.repositories

import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.db.UserDao
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.models.asDomainModel
import com.natife.example.networkandbdapp.ui.MainActivity

class UserRepository(private val userDao: UserDao, private val api: Requests) {

    private val numberRequestedUsers = 10

    suspend fun getAllUsers(): List<DomainUser> {
        return try {
            val users = api.getUserInfo(numberRequestedUsers).asDomainModel()
            userDao.insert(users.asDatabaseModel())
            MainActivity.isFirstRequest = false
            users
        } catch (e: Exception) {
            e.printStackTrace()
            if (MainActivity.isFirstRequest) {
                MainActivity.isFirstRequest = false
                userDao.getAllUsers().asDomainModel()
            } else {
                emptyList()
            }
        }
    }

    fun getSingleUserInfo(id: String): DomainUser {
        return userDao.getUser(id).asDomainModel()
    }

    suspend fun checkInternet() {
        try {
            api.getUserInfo(numberRequestedUsers).asDomainModel()
            userDao.clearAllUsers()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

}
