package com.natife.example.networkandbdapp.di

import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserFetcher
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.DataBaseRepository
import com.natife.example.networkandbdapp.data.database.UserDataBase
import com.natife.example.networkandbdapp.data.network.RetrofitClient
import com.natife.example.networkandbdapp.data.network.UserFetcherImpl
import com.natife.example.networkandbdapp.ui.userListScreen.UserListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

val UserDBRepQualifier = StringQualifier("Test1")
val UserRepQualifier = StringQualifier("Test2")

val dataModule = module {
    factory<UserFetcher> { UserFetcherImpl(RetrofitClient.api) }
    factory<UserDataRepository> (UserDBRepQualifier){ DataBaseRepository(UserDataBase.getInstance(androidContext()).userDao) }
    single<UserDataRepository> (UserRepQualifier) { UserRepository(get(UserDBRepQualifier), get()) }
}

val viewModelModule = module {
    viewModel { UserListViewModel(get(UserRepQualifier)) }
}