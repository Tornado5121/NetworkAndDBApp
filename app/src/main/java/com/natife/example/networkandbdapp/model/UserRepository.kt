package com.natife.example.networkandbdapp.model

import com.natife.example.networkandbdapp.domain.DomainUser

class UserRepository(
    private val databaseRepo: UserRepository1,
    private val userFetcher: UserFetcher
) : UserRepository1 {


    private var isFirstRequest = true

//    //TODO вынести логику работы с экстеншенами в отдельную логику
//    suspend fun getAllUsers(): List<DomainUser> {
//        return try {
//            val users = api.getUserInfo(numberRequestedUsers).asDomainModel()
//            if (isFirstRequest) {
//                userDao.clearAllUsers()
//            }
//            userDao.insert(users.asDatabaseModel())
//            isFirstRequest = false
//            users
//        } catch (e: Exception) {
//            e.printStackTrace()
//            if (isFirstRequest) {
//                isFirstRequest = false
//                userDao.getAllUsers().asDomainModel()
//            } else {
//                emptyList()
//            }
//        }
//    }
//
//    fun getSingleUserInfo(id: String): DomainUser {
//        return userDao.getUser(id).asDomainModel()
//    }

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

interface UserFetcher {

    suspend fun getUsers(): List<DomainUser>

}

interface UserRepository1 : UserFetcher {

    suspend fun saveUsers(users: List<DomainUser>)
    suspend fun getUserById(id: String): DomainUser
    suspend fun clearUsers()

}

//interface NumberParser {
//
//    fun parseInt(input: String): Int
//    fun parseLong(input: String): Long
//    fun parseFloat(input: String): Float
//    fun parseDouble(input: String): Double
//
//}
//
//open class NumberParserImpl : NumberParser {
//
//    override fun parseInt(input: String): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun parseLong(input: String): Long {
//        TODO("Not yet implemented")
//    }
//
//    override fun parseFloat(input: String): Float {
//        TODO("Not yet implemented")
//    }
//
//    override fun parseDouble(input: String): Double {
//        TODO("Not yet implemented")
//    }
//
//}
//
//class SafeNumberParser(parent: NumberParser) : NumberParser by parent {
//
//    override fun parseInt(input: String): Int {
//        return try {
//            input.toInt()
//        } catch (e: Exception) {
//            0
//        }
//    }
//
//}
//
//class SomeVieModel(private val parser: NumberParser) {
//
//    fun getNumber(str: String) {
//        parser.parseInt(str)
//    }
//
//}
