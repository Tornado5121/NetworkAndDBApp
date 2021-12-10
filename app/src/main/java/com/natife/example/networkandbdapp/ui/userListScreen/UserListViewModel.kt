package com.natife.example.networkandbdapp.ui.userListScreen

import android.content.Context
import androidx.lifecycle.*
import com.natife.example.networkandbdapp.UserRepository
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.asDomainModel
import com.natife.example.networkandbdapp.domain.DomainUser
import com.natife.example.networkandbdapp.models.UserArray
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserListViewModel(context: Context) : ViewModel() {

    private val repository = UserRepository(UserDataBase.getInstance(context))

    val userList: LiveData<List<DomainUser>> = Transformations.map(repository.database.userDao.getAllUsersByLiveData()) {
        it.asDomainModel()
    }

    init {
        refreshUserDB()
    }

    private fun refreshUserDB() {
        viewModelScope. launch {
            repository.refreshUsers()
        }
    }
}