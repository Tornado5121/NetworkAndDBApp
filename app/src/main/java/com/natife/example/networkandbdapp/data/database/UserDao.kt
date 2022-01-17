package com.natife.example.networkandbdapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insert(users: List<UserEntity>?)

    @Query("SELECT * from userentity")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * from userentity WHERE id = :key")
    fun getUser(key: String): UserEntity

    @Query("DELETE FROM userentity")
    fun clearAllUsers()

}