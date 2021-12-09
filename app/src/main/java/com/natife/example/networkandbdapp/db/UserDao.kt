package com.natife.example.networkandbdapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.natife.example.networkandbdapp.models.User

@Dao
interface UserDao {
    @Insert
    fun insert(users: List<UserEntity>)

    @Query("SELECT * from userentity")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * from userentity WHERE id = :key")
    fun getUser(key: String?): UserEntity

    @Query("DELETE FROM userentity")
    fun clearAllUsers()
}