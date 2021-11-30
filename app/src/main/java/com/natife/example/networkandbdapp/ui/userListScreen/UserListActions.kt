package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.models.User

sealed class UserListActions {

    object LoadingUserData : UserListActions()
    class UserDataLoaded(userList: List<User>) : UserListActions()
    class Error(e: Exception) : UserListActions()
    object None : UserListActions()

}