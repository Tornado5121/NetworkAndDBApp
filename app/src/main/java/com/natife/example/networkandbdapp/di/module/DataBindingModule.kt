package com.natife.example.networkandbdapp.di.module

import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.DataBaseRepository
import com.natife.example.networkandbdapp.data.network.UserFetcherImpl
import com.natife.example.networkandbdapp.di.qualifiers.MyDatabaseRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataBindingModule {

    @Singleton
    @Binds
    abstract fun provideUserRepo(
        userRepository: UserRepository
    ): UserDataRepository

    @Singleton
    @Binds
    abstract fun provideUserFetcherImpl(userFetcherImpl: UserFetcherImpl): UserFetcher

    @Singleton
    @Binds
    @MyDatabaseRepo
    abstract fun provideUserDatabaseRepo(userDataBaseRepository: DataBaseRepository): UserDataRepository

}