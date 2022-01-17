package com.natife.example.networkandbdapp.data

import com.natife.example.networkandbdapp.domain.DomainUser

interface UserDataRepository : UserFetcher {

    suspend fun saveUsers(users: List<DomainUser>)
    suspend fun getUserById(id: String): DomainUser
    suspend fun clearUsers()

}