package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.models.User
import com.natife.example.networkandbdapp.models.UserArray

sealed class UserListActions {

    object LoadUserData : UserListActions()
    class UserDataLoaded(userList: List<User>) : UserListActions()
    class Error(val error: UserListState) : UserListActions()
    object None : UserListActions()


    object DisplayUserList : UserListActions()
    class UserListDisplayed(val userNameList: List<String>) : UserListActions()

    object WriteToDbUserInfo : UserListActions()
    class UserInfoAddedToDB(val list: List<UserArray>): UserListActions()
}