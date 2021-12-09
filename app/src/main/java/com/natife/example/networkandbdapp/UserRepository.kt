package com.natife.example.networkandbdapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.models.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val context: Context, private val database: UserDataBase) {

    val users: LiveData<List<DomainUser>> = Transformations.map(database.userDao.getAllUsers()) {
        it.asDomainModel()
    }

//    suspend fun getUserArray(): UserArray {
//        return RetrofitClient.api.getUserInfo(10)
//    }

//    var userList = listOf<User>()
//
//    fun getData() {
//        val retrofitClient = RetrofitClient.getInstance()?.create(Requests::class.java)
//        val call = retrofitClient?.getUserInfo(10)
//        call?.enqueue(object : Callback<UserArray> {
//            override fun onResponse(call: Call<UserArray>, response: Response<UserArray>) {
//                userList = response.body()?.userArray ?: emptyList()
//            }
//
//            override fun onFailure(call: Call<UserArray>, t: Throwable) {
//                t.printStackTrace()
//            }
//        }
//        )
//    }

    suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
        val userList = RetrofitClient.api.getUserInfo(1)
        database.userDao.insert(userList.asDatabaseModel())
        }
    }

    suspend fun getSingleUserInfo(id: String?) : DomainUser {
        lateinit var user: DomainUser
        withContext(Dispatchers.IO) {
            val userDb: UserDataBase = UserDataBase.getInstance(context)
            user = userDb.userDao.getUser(id).asDomainModel()

        }
        return user
    }

//    fun writeUserDataToDataBase() {
//    }
//
//    fun readUserDataFromDataBase() {
//
//    }

}

//fun ImageView.loadImage(url: String) {
//    Glide.with(this)
//        .load(url)
//        .into(this)
//}

