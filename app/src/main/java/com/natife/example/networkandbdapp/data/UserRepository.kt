package com.natife.example.networkandbdapp.data

import com.natife.example.networkandbdapp.domain.DomainUser
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val databaseRepo: UserDataRepository,
    private val userFetcher: UserFetcher
) : UserDataRepository {

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

