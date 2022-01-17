package com.natife.example.networkandbdapp.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDataBase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getInstance(context: Context): UserDataBase {
            val currentInstance = INSTANCE
            if (currentInstance != null) {
                return currentInstance
            }

            synchronized(this) {
                val dataBaseInstance = INSTANCE
                return if (dataBaseInstance != null) {
                    dataBaseInstance
                } else {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataBase::class.java,
                        "user_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }

}