package com.natife.example.networkandbdapp.ui.userListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListViewModel(
    private val repository: UserRepository,
    private val database: UserDataBase
) : ViewModel() {

    private val _userFirstNameList = MutableLiveData<List<DomainUser>>()
    val userFirstNameList: LiveData<List<DomainUser>>
        get() = _userFirstNameList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val users = repository.getAllUsersByApi()
            if (users != null) {
                database.userDao.clearAllUsers()
                database.userDao.insert(users.asDatabaseModel())
            }
            val data = database.userDao.getAllUsers().asDomainModel()

            withContext(Dispatchers.Main) {
                _userFirstNameList.value = data
            }
        }
    }
}