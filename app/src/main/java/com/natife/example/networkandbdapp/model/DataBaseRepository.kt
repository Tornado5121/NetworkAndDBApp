package com.natife.example.networkandbdapp.model

import com.natife.example.networkandbdapp.db.UserDao
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel

class DataBaseRepository(private val userDao: UserDao) : UserRepository1 {
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