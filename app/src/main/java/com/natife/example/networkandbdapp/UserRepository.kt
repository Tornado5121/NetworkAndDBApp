package com.natife.example.networkandbdapp

import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.models.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(val database: UserDataBase) {

    private val numberRequestedUsers = 10

    suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
            database.userDao.clearAllUsers()
            try {
                val userList = RetrofitClient.api.getUserInfo(numberRequestedUsers)
                database.userDao.insert(userList.asDatabaseModel())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun getSingleUserInfo(id: String?): DomainUser {
        lateinit var user: DomainUser
        withContext(Dispatchers.IO) {
            user = database.userDao.getUser(id).asDomainModel()
        }
        return user
    }
}
