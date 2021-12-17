package com.natife.example.networkandbdapp.ui.userListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.repositories.UserRepository

class UserListViewModelFactory(
    private val repository: UserRepository,
    private val database:UserDataBase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(repository) as T
    }

}