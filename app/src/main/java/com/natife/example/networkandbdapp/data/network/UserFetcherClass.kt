package com.natife.example.networkandbdapp.data.network

import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.retrofitModels.asDomainModel

class UserFetcherClass(private val api: Requests) : UserFetcher {

    private val numberRequestedUsers = 10

    override suspend fun getUsers(): List<DomainUser> {
        return api.getUserInfo(numberRequestedUsers).asDomainModel()
    }

}