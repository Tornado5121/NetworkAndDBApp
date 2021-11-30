package com.natife.example.networkandbdapp.db

import androidx.room.Insert
import androidx.room.Query
import com.natife.example.networkandbdapp.models.User

interface UserDao {

    @Insert
    fun insertAll(userList: ArrayList<User>)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

}