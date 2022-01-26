package com.natife.example.networkandbdapp.di.module

import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.DataBaseRepository
import com.natife.example.networkandbdapp.data.network.UserFetcherImpl
import com.natife.example.networkandbdapp.di.qualifiers.MyDatabaseRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class DataBindingModule {

    @ActivityScoped
    @Binds
    abstract fun provideUserRepo(
        userRepository: UserRepository
    ): UserDataRepository

    @ActivityScoped
    @Binds
    abstract fun provideUserFetcherImpl(userFetcherImpl: UserFetcherImpl): UserFetcher

    @ActivityScoped
    @Binds
    @MyDatabaseRepo
    abstract fun provideUserDatabaseRepo(userDataBaseRepository: DataBaseRepository): UserDataRepository

}