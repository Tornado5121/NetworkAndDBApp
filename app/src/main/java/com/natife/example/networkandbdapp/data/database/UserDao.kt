package com.natife.example.networkandbdapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import javax.inject.Singleton

@Dao
@Singleton
interface UserDao {

    @Insert
    fun insert(users: List<UserEntity>?)

    @Query("SELECT * from userEntity")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * from userEntity WHERE id = :key")
    fun getUser(key: String): UserEntity

    @Query("DELETE FROM userEntity")
    fun clearAllUsers()

}