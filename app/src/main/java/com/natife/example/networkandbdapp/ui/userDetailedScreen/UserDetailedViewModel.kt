package com.natife.example.networkandbdapp.ui.userDetailedScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.UserRepository
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.domain.DomainUser
import kotlinx.coroutines.launch

class UserDetailedViewModel(context: Context) : ViewModel() {

    private val userRepository = UserRepository(UserDataBase.getInstance(context))

    private val _detailedUser = MutableLiveData<DomainUser>()
    val detailedUser: LiveData<DomainUser> = _detailedUser

    fun getUserDetailedInfo(name: String?) {
        viewModelScope.launch {
            _detailedUser.value = userRepository.getSingleUserInfo(name)
        }
    }
}