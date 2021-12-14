package com.natife.example.networkandbdapp.ui.userListScreen

import androidx.lifecycle.*
import com.natife.example.networkandbdapp.db.UserEntity
import com.natife.example.networkandbdapp.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserRepository) : ViewModel() {

    init {
        refreshUserDB()
    }

    private fun refreshUserDB() {
        viewModelScope. launch(Dispatchers.IO) {
            repository.refreshUsers()
        }
    }

    fun getUserNameList() : LiveData<List<UserEntity>> {
        return repository.userList
    }
}