package com.natife.example.networkandbdapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natife.example.networkandbdapp.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val userRepository: UserRepository): ViewModel() {

    fun clearDbForFirstLaunchAfterNoInternet() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.checkInternet()
        }
    }

}