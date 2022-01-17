package com.natife.example.networkandbdapp.model

import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.retrofitModels.asDomainModel

class UserFetcherClass(private val api: Requests) : UserFetcher {

    private val numberRequestedUsers = 10

    override suspend fun getUsers(): List<DomainUser> {
        return api.getUserInfo(numberRequestedUsers).asDomainModel()
    }
}