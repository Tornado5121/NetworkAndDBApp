package com.natife.example.networkandbdapp.ui.userDetailedScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.data.UserDataRepository
import com.natife.example.networkandbdapp.domain.asDatabaseModel
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.data.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailedViewModel(private val userRepository: UserDataRepository) : ViewModel() {

    private val _detailedUser = MutableLiveData<UserEntity>()
    val detailedUser: LiveData<UserEntity> = _detailedUser

    fun getUserDetailedInfo(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUserById(id)
            _detailedUser.postValue(user.asDatabaseModel())
        }
    }

}