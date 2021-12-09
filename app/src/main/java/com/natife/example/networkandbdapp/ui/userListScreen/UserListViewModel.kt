package com.natife.example.networkandbdapp.ui.userListScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.UserRepository
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.models.UserArray
import kotlinx.coroutines.launch

class UserListViewModel(context: Context) : ViewModel() {

    private val repository = UserRepository(context, UserDataBase.getInstance(context))

    private val userRepository = UserRepository(context, UserDataBase.getInstance(context))

    val userList = userRepository.users

    private val _myResponse: MutableLiveData<UserArray> = MutableLiveData()
    val myResponse: LiveData<UserArray>
        get() = _myResponse

    init {
        refreshUserDB()
    }

    private fun refreshUserDB() {
        viewModelScope. launch {
            repository.refreshUsers()
        }
    }
}