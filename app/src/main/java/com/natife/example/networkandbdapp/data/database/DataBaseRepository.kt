package com.natife.example.networkandbdapp.data.database

import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import javax.inject.Inject

class DataBaseRepository @Inject constructor(private val userDao: UserDao) : UserDataRepository {

    override suspend fun saveUsers(users: List<DomainUser>) {
        userDao.insert(users.asDatabaseModel())
    }

    override suspend fun getUserById(id: String): DomainUser {
        return userDao.getUser(id).asDomainModel()
    }

    override suspend fun clearUsers() {
        userDao.clearAllUsers()
    }

    override suspend fun getUsers(): List<DomainUser> {
        return userDao.getAllUsers().asDomainModel()
    }

}