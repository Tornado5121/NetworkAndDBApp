package com.natife.example.networkandbdapp.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.natife.example.networkandbdapp.models.User

@Database(entities = arrayOf(User::class) , version = 1)
abstract class DataBaseHandler : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}