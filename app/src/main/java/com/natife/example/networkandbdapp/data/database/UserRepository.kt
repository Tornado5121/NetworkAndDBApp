package com.natife.example.networkandbdapp.data.database

import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.domain.DomainUser

interface UserRepository : UserFetcher {

    suspend fun saveUsers(users: List<DomainUser>)
    suspend fun getUserById(id: String): DomainUser
    suspend fun clearUsers()

}