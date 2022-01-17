package com.natife.example.networkandbdapp.data

import com.natife.example.networkandbdapp.data.database.UserRepository
import com.natife.example.networkandbdapp.domain.DomainUser

class UserRepository(
    private val databaseRepo: UserRepository,
    private val userFetcher: UserFetcher
) : UserRepository {

    private var isFirstRequest = true

    override suspend fun saveUsers(users: List<DomainUser>) {
        databaseRepo.saveUsers(users)
    }

    override suspend fun getUserById(id: String): DomainUser {
        return databaseRepo.getUserById(id)
    }

    override suspend fun clearUsers() {
        databaseRepo.clearUsers()
    }

    override suspend fun getUsers(): List<DomainUser> {
        return try {
            val users = userFetcher.getUsers()
            if (isFirstRequest) {
                databaseRepo.clearUsers()
            }
            databaseRepo.saveUsers(users)
            isFirstRequest = false
            users
        } catch (e: Exception) {
            e.printStackTrace()
            if (isFirstRequest) {
                isFirstRequest = false
                databaseRepo.getUsers()
            } else {
                emptyList()
            }
        }
    }

}

