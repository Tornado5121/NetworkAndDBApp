package com.natife.example.networkandbdapp.ui.userListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: UserDataRepository
) : ViewModel() {

    private val _userFirstNameList = MutableLiveData<List<DomainUser>>()
    val userFirstNameList: LiveData<List<DomainUser>> = _userFirstNameList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _userFirstNameList.postValue(repository.getUsers())
        }
    }

    fun getNextPageUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newUsers = repository.getUsers()
                val currentUsers = _userFirstNameList.value ?: listOf()
                _userFirstNameList.postValue(currentUsers + newUsers)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}