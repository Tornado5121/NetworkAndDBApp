package com.natife.example.networkandbdapp.ui.userListScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.networkandbdapp.UserRepository

class UserListViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(context) as T
    }
}