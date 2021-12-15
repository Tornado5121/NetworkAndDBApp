package com.natife.example.networkandbdapp.repositories

import androidx.lifecycle.LiveData
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.UserEntity
import com.natife.example.networkandbdapp.models.asDatabaseModel

class UserRepository(private val database: UserDataBase) {

    private val numberRequestedUsers = 10
    val userList: LiveData<List<UserEntity>> = database.userDao.getAllUsersByLiveData()

    suspend fun refreshUsers() {
            database.userDao.clearAllUsers()
            try {
                val userList = RetrofitClient.api.getUserInfo(numberRequestedUsers)
                database.userDao.insert(userList.asDatabaseModel())
            } catch (e: Exception) {
                e.printStackTrace()
            }
    }

    fun getSingleUserInfo(id: String): UserEntity {
        return database.userDao.getUser(id)
    }

}
