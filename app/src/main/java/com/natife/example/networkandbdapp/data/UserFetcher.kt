package com.natife.example.networkandbdapp.data

import com.natife.example.networkandbdapp.domain.DomainUser

interface UserFetcher {

    suspend fun getUsers(): List<DomainUser>

}