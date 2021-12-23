package com.natife.example.networkandbdapp.ui.userListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _userFirstNameList = MutableLiveData<List<DomainUser>>()
    val userFirstNameList: LiveData<List<DomainUser>> = _userFirstNameList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _userFirstNameList.postValue(repository.getAllUsers())
        }
    }

    fun getNextPageUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newUsers = repository.getAllUsers()
                if (newUsers != _userFirstNameList.value)
                    _userFirstNameList.postValue((_userFirstNameList.value ?: listOf()) + newUsers)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}