package com.natife.example.networkandbdapp.ui.userDetailedScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.data.UserRepository

class UserListViewModelFactory(
    private val repository: UserDataRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailedViewModel(repository) as T
    }

}