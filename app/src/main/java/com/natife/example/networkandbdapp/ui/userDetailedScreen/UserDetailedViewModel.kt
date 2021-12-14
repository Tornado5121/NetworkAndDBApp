package com.natife.example.networkandbdapp.ui.userDetailedScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.db.UserEntity
import com.natife.example.networkandbdapp.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailedViewModel(context: Context) : ViewModel() {


    private val userRepository = UserRepository(UserDataBase.getInstance(context))

    private val _detailedUser = MutableLiveData<UserEntity>()
    val detailedUser: LiveData<UserEntity> = _detailedUser

    fun getUserDetailedInfo(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getSingleUserInfo(id)
            withContext(Dispatchers.Main) {
                _detailedUser.postValue(user)
            }
        }
    }
}